package com.lin.wechat;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.lin.interfacePackage.AbstractVariableParamPlugin;
import com.lin.interfacePackage.Annotation.InitParam;
import com.lin.interfacePackage.Annotation.PluginAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotationClass;
import com.lin.interfacePackage.request.VariableParamReq;
import com.lin.interfacePackage.request.VariableParamResp;
import com.lin.wechat.req.AccessTokenReq;
import com.lin.wechat.req.GenerateReq;
import com.lin.wechat.req.JsApiReq;
import com.lin.wechat.req.WappQrcodeReq;
import com.lin.wechat.req.WebpageContentReq;
import com.lin.wechat.req.WechatPayReq;
import com.lin.wechat.resp.AccessTokenResp;
import com.lin.wechat.resp.GenerateResp;
import com.lin.wechat.resp.JsApiResp;
import com.lin.wechat.resp.WappQrcodeResp;
import com.lin.wechat.resp.WebpageContentResp;
import com.lin.wechat.resp.WechatPayResp;

@PluginAnnotation(name = "微信功能", introduce = "", belongType = 1)
public class WechatClass extends AbstractVariableParamPlugin {

	// @InitParam
	// ProcessIntro intro;

	@InitParam
	HttpClient httpClient;

	// @InitParam
	// StorageClient client;

	DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

	DocumentFactory factory = DocumentFactory.getInstance();

	@PluginMethodAnnotation(name = "微信token")
	public void getAccessToken(AccessTokenReq req, AccessTokenResp resp) {
		HttpGet http = new HttpGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
				+ req.getAppid() + "&secret=" + req.getAppSecret());
		try {
			HttpResponse response = httpClient.execute(http);
			String jsonString = new String(EntityUtils.toString(response.getEntity()));
			JSONObject ob = JSON.parseObject(jsonString);
			if (ob.containsKey("errcode")) {
				resp.setResult(ob.getString("errmsg"));
			} else {
				resp.setResult("OK");
				resp.setToken(ob.getString("access_token"));
				resp.setTime(String.valueOf(System.currentTimeMillis()));
				resp.setExpire(String.valueOf(ob.getIntValue("expires_in")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PluginMethodAnnotation(name = "微信jsapi")
	public void getJsAPI(JsApiReq req, JsApiResp resp) {
		HttpGet http = new HttpGet("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="
				+ req.getAccessToken() + "&type=jsapi");
		try {
			HttpResponse response = httpClient.execute(http);
			String jsonString = new String(EntityUtils.toString(response.getEntity()));
			JSONObject ob = JSON.parseObject(jsonString);
			resp.setResult(ob.getString("errcode"));
			resp.setTicket(ob.getString("ticket"));
			resp.setTime(String.valueOf(System.currentTimeMillis()));
			resp.setExpire(String.valueOf(ob.getIntValue("expires_in")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PluginMethodAnnotation(name = "微信网页授权")
	public void getWebpageContent(WebpageContentReq req, WebpageContentResp resp) {
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + req.getAppid() + "&secret="
				+ req.getSecret() + "&code=" + req.getCode() + "&grant_type=authorization_code";
		HttpGet http = new HttpGet(url);
		try {
			HttpResponse response = httpClient.execute(http);
			String jsonString = new String(EntityUtils.toString(response.getEntity()));
			JSONObject ob = JSON.parseObject(jsonString);
			resp.setOpenid(ob.getString("openid"));
			resp.setPageToken(ob.getString("access_token"));
			resp.setExpire(String.valueOf(ob.getIntValue("expires_in")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@PluginMethodAnnotation(name = "小程序码")
	public void generateWappQrcode(WappQrcodeReq req, WappQrcodeResp resp) {
		HttpPost http = new HttpPost(
				"https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=" + req.getAccessToken());
		try {
			http.setEntity(new StringEntity(JSON.toJSONString(req), "utf-8"));
			HttpResponse response = httpClient.execute(http);

			Header[] header = response.getHeaders("Content-Type");
			if (header.length > 0 && header[0].getValue().contains("image/jpeg")) {

			} else if (header.length > 0 && header[0].getValue().contains("application/json")) {
				String jsonString = new String(EntityUtils.toString(response.getEntity()));
				JSONObject ob = JSON.parseObject(jsonString);
				resp.setStatus(String.valueOf(ob.get("errcode")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PluginMethodAnnotation(name = "本地小程序码")
	public void generateWappQrcodeLocal(WappQrcodeReq req, WappQrcodeResp resp) {
		HttpPost http = new HttpPost(
				"https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=" + req.getAccessToken());
		try {
			JSONObject ob = new JSONObject();
			if (req.getIsHyaline() != null)
				ob.put("is_hyaline", Boolean.parseBoolean(req.getIsHyaline()));
			ob.put("page", req.getPage());
			ob.put("scene", req.getScene());
			ob.put("width", req.getWidth());

			http.setEntity(new StringEntity(JSON.toJSONString(ob), "utf-8"));
			System.out.println("wx qrcode req");
			System.out.println(JSON.toJSONString(ob));
			HttpResponse response = httpClient.execute(http);

			Header[] header = response.getHeaders("Content-Type");
			if (header.length > 0 && header[0].getValue().contains("image/jpeg")) {
				System.out.println("file path=" + req.getFilePath());

				Path path = Paths.get(req.getFilePath());
				Path parentDir = path.getParent();
				if (!Files.exists(parentDir))
					Files.createDirectories(parentDir);

				Files.write(path, EntityUtils.toByteArray(response.getEntity()));
				resp.setStatus("OK");
			} else if (header.length > 0 && header[0].getValue().contains("application/json")) {
				String jsonString = new String(EntityUtils.toString(response.getEntity()));
				JSONObject returnOb = JSON.parseObject(jsonString);
				resp.setStatus(String.valueOf(returnOb.get("errcode")));
				System.out.println("wx qrcode");
				System.out.println(jsonString);
			}

		} catch (Exception e) {
			resp.setStatus("FAIL");
			e.printStackTrace();
		}
	}

	// @PluginMethodAnnotation(name = "微信支付二维码")
	public void generateQRCode(GenerateReq req, GenerateResp resp) {
		String url = "https://api.mch.weixin.qq.com/sandboxnew/pay/unifiedorder";
		HttpPost httppost = new HttpPost(url);

		httppost.setEntity(new StringEntity(generateXML(req).asXML(), "utf-8"));
		try {
			HttpResponse response = httpClient.execute(httppost);
			String docString = new String(EntityUtils.toString(response.getEntity()));
			Document document = DocumentHelper.parseText(docString);
			Element element = document.getRootElement();
			String resultCode = element.element("return_code").getText();
			if (resultCode.equals("FAIL")) {
				resp.setMsg(element.elementText("return_msg"));
				resp.setResultCode(resultCode);

				return;
			}

			String appid = element.elementText("appid");
			String mchId = element.elementText("mch_id");
			String device_info = element.elementText("device_info");
			String randomString = element.elementText("nonce_str");
			String sign = element.elementText("sign");
			// String compareSign = generateSign(appid, "", device_info, mchId,
			// randomString, req.getAesKey());
			// if (!compareSign.equals(sign)) {
			// resp.setMsg("密钥对比错误");
			// resp.setResultCode("FAIL");
			// System.out.println(docString);
			// return;
			// }

			resultCode = element.elementText("result_code");
			if (resultCode.equals("FAIL")) {
				resp.setMsg(element.elementText("err_code_des"));
				resp.setResultCode(element.elementText("result_code"));
				return;
			}

			String prepay_id = element.elementText("result_code");
			String code_url = element.elementText("code_url");

			String path = generateQRcode(code_url);
			resp.setMsg(element.elementText("return_msg"));
			resp.setPicUrl(path);
			resp.setResultCode("SUCCESS");

		} catch (IOException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String generateQRcode(String str) {

		// TODO Auto-generated method stub
		String content = str;// 内容
		int width = 200; // 图像宽度
		int height = 200; // 图像高度
		String format = "png";// 图像类型
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵
			BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
			ByteArrayOutputStream steam = new ByteArrayOutputStream();
			String[] path = null;
			ImageIO.write(image, format, new File("d:\123.png"));
			// path = client.upload_file(steam.toByteArray(), format, null);

			StringBuilder builder = new StringBuilder();
			for (String s : path) {
				builder.append("/" + s);
			}
			return builder.toString();
		} catch (IOException | WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	private Document generateXML(GenerateReq req) {

		Document document = DocumentHelper.createDocument();
		Element element = document.addElement("xml");
		// document.addElement("appid");
		element.addElement("appid").addText(req.getAppid());
		element.addElement("mch_id").addText(req.getMch_id());
		element.addElement("device_info").addText(req.getDevice_info());
		String randomString = generateRandomString();
		element.addElement("nonce_str").addText(randomString);

		// element.addElement("sign_type").addText("MD5");
		element.addElement("body").addText(req.getBody());
		element.addElement("detail").addText(req.getDetail());
		element.addElement("attach").addText(req.getAttach());
		element.addElement("out_trade_no").addText(req.getOut_trade_no());
		element.addElement("fee_type").addText(req.getFee_type());
		element.addElement("total_fee").addText(String.valueOf(req.getTotal_fee()));
		element.addElement("spbill_create_ip").addText(req.getFee_type());

		Calendar cal = Calendar.getInstance();
		element.addElement("time_start").addText(dateFormat.format(cal.getTime()));
		cal.add(Calendar.MINUTE, Integer.parseInt(req.getTime_expire()));
		element.addElement("time_expire").addText(dateFormat.format(cal.getTime()));

		element.addElement("notify_url").addText(req.getNotify_url()); // 在页面申请

		element.addElement("trade_type").addText("MICROPAY");
		element.addElement("scene_info").addText(req.getScene_info());

		JSONObject ob = (JSONObject) JSON.toJSON(req);

		// element.addElement("sign").addText(generateSign(ob,req.getAesKey()));

		return document;
	}

	private String generateSign(HashMap<String, String> map, String key) {
		Set<String> set = map.keySet();
		List<String> list = new ArrayList<String>();
		for (String s : set) {
			list.add(s);
		}

		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s + "=" + map.get(s) + "&");
		}
		sb.append("key=" + key);
		String sign = encodePass(sb.toString(), PasswordType.MD5).toUpperCase();
		return sign;
	}

	private String generateRandomString() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		String uuidStr = str.replace("-", "");
		return uuidStr;
	}

	@PluginMethodAnnotation(name = "处理微信支付通知")
	public void wechatPayRecall(WechatPayReq req, WechatPayResp resp) {

	}

	public String getSandboxKeyXml(String mch_id) {
		String randomString = generateRandomString();
		Document document = DocumentHelper.createDocument();
		Element element = document.addElement("xml");
		// document.addElement("appid");
		element.addElement("mch_id").addText(mch_id);
		element.addElement("nonce_str").addText(randomString);
		element.addElement("sign").addText(randomString);
		return document.asXML();
	}

	@Override
	public void getParams(VariableParamReq req, VariableParamResp resp) {

		if (req.getMethodName().equals("setResult")) {
			List<PluginMethodParamAnnotationClass> list = new ArrayList<PluginMethodParamAnnotationClass>();
			List<PluginMethodParamAnnotationClass> list2 = new ArrayList<PluginMethodParamAnnotationClass>();
			// for (ProcessArgument pa : intro.getOutArgs()) {
			// PluginMethodParamAnnotationClass clz = new
			// PluginMethodParamAnnotationClass(pa.getName(),
			// ParamType.Optional, null, null, null, "map");
			// list.add(clz);
			//
			// PluginMethodParamAnnotationClass clz2 = new
			// PluginMethodParamAnnotationClass(pa.getName(),
			// ParamType.Optional, null, null, null, "outMap");
			// list2.add(clz2);
			//
			// }

			resp.setInArgs(list);
			resp.setOutArgs(list2);
		}

		// TODO Auto-generated method stub
	}

	public enum PasswordType {
		MD5, SHA256, SHA384, SHA512, Base64
	}

	public static String encodePass(String password, PasswordType type) {
		String newPass = null;
		if (type == PasswordType.MD5)
			newPass = DigestUtils.md5Hex(password);
		else if (type == PasswordType.SHA256)
			newPass = DigestUtils.sha256Hex(password);
		else if (type == PasswordType.SHA384)
			newPass = DigestUtils.sha384Hex(password);
		else if (type == PasswordType.SHA512)
			newPass = DigestUtils.sha512Hex(password);
		else if (type == PasswordType.Base64)
			try {
				newPass = new String(Base64.encodeBase64(password.getBytes("UTF-8")));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		else
			newPass = DigestUtils.md5Hex(password);
		// return newPass.toUpperCase();
		return newPass;
	}

	public static String decodePass(String password) {
		String newPass = null;
		// if (type == PasswordType.Base64)
		newPass = new String(Base64.decodeBase64(password));
		return newPass;
	}

	public static String streamToMD5(InputStream inputStream) {
		try {
			return DigestUtils.md5Hex(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String fileToMD5(File file) {
		try {
			FileInputStream in = new FileInputStream(file);
			return DigestUtils.md5Hex(in);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String fileToMD5(InputStream file) {
		try {
			return DigestUtils.md5Hex(file);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String fileToSha1(InputStream file) {
		try {
			return DigestUtils.sha512Hex(file);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Key createKey() throws NoSuchAlgorithmException {
		KeyGenerator generator = KeyGenerator.getInstance("DES");
		generator.init(new SecureRandom());
		Key key = generator.generateKey();
		return key;
	}

	public static Key getKey(InputStream is) {
		try {
			ObjectInputStream ois = new ObjectInputStream(is);
			return (Key) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private static byte[] doEncrypt(Key key, byte[] data) {
		try {
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] raw = cipher.doFinal(data);
			return raw;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static InputStream doDecrypt(Key key, InputStream in) {
		try {
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, key);
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			byte[] tmpbuf = new byte[1024];
			int count = 0;
			while ((count = in.read(tmpbuf)) != -1) {
				bout.write(tmpbuf, 0, count);
				tmpbuf = new byte[1024];
			}
			in.close();
			byte[] orgData = bout.toByteArray();
			byte[] raw = cipher.doFinal(orgData);
			ByteArrayInputStream bin = new ByteArrayInputStream(raw);
			return bin;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 解密，三步走。
	 * 
	 * @param key
	 * @param encodedText
	 * @return
	 */
	public static String RSADecode(PrivateKey key, byte[] encodedText) {

		try {
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(Cipher.DECRYPT_MODE, key);
			return new String(cipher.doFinal(encodedText));
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static PrivateKey get(String filename) throws Exception {
		List<String> list = Files.readAllLines(Paths.get(filename), Charset.forName("utf-8"));
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s);
		}
		String s = sb.toString();

		byte[] keyBytes = Base64.decodeBase64(s);

		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePrivate(spec);
	}

	public static void main(String[] args) throws Exception {
		PrivateKey key = get("f:\\app_private_key_pkcs8.pem");
		try {
			PrivateKey priKey = key;
			java.security.Signature signature = java.security.Signature.getInstance("SHA256WithRSA");
			signature.initSign(priKey);
			signature.update("a=123".getBytes());
			byte[] signed = signature.sign();
			System.out.println(Base64.encodeBase64String(signed));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// get the public key

		// MainClass clz = new MainClass();
		//
		// HttpClientBuilder bu = HttpClientBuilder.create();
		// clz.httpClient = bu.build();
		//
		// String url =
		// "https://api.mch.weixin.qq.com/sandboxnew/pay/getsignkey";
		// HttpPost httppost = new HttpPost(url);
		// httppost.setEntity(new
		// StringEntity(clz.getSandboxKeyXml("1332467601"), "utf-8"));
		// try {
		// HttpResponse response = clz.httpClient.execute(httppost);
		// String docString = new
		// String(EntityUtils.toString(response.getEntity()));
		// System.out.println(docString);
		// } catch (Exception e) {
		// // TODO: handle exception
		// }

		//
		// GenerateReq req = new GenerateReq();
		// req.setAesKey("QM2DyFu1FmCu9weC0koOkQITmhD9LtG2outB6XNIu3G");
		// req.setAppid("wx1f94c3b81bbe6d08");
		// req.setAttach("");
		// req.setBody("");
		// req.setDetail("");
		// req.setDevice_info("");
		// req.setFee_type("CNY");
		// req.setGoods_tag("");
		// req.setMch_id("1332467601");
		// req.setNotify_url("http://wechat.13322.com/wechat-server/wechat");
		// req.setOut_trade_no("123123123");
		// req.setProduct_id("1");
		// req.setScene_info("test");
		// req.setTime_expire("30");
		// req.setTotal_fee(1);
		// GenerateResp resp = new GenerateResp();
		// clz.generateQRCode(req, resp);
		// System.out.println(JSON.toJSONString(resp));
	}

}
