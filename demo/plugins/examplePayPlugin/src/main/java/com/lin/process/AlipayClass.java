package com.lin.process;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.lin.interfacePackage.AbstractPlugin;
import com.lin.interfacePackage.Annotation.PluginAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodAnnotation;
import com.lin.process.req.AlipayReq;
import com.lin.process.req.CheckAlipayNotifyReq;
import com.lin.process.req.TransferReq;
import com.lin.process.resp.AlipayResp;
import com.lin.process.resp.CheckAlipayNotifyResp;
import com.lin.process.resp.TransferResp;

@PluginAnnotation(name = "支付宝", introduce = "没什么好说的", belongType = 1)
public class AlipayClass extends AbstractPlugin {
	String aliPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA01gcDBKh/BSFdNoI+l/yra3EzsYps5W/THF3+2p0XZcconRsTbqWzuDCkMaKKp4s/Eq13TimTInl+NODESCy0oS8W/GpQsVG2V51uw2BmFNaA6YYvpdBJ/3Ds+3XaevrOfyQZ8ZvsGEabRKaDWhu6tPgBf2LS47KdX95YcFteKdyk8IbljNiGwzw/5+cY4uJwy1ChK02AeQS+gzeD5TTvClIT0l/WDJD0krRLWCdneLev8WhHEQ5oXc3u2Ew0jQGAojrEWLMwwSBRDNGazhN/nXEmuPSRsAezhOTMLjWZlHxOz6EkdTe6i8EoV4Gu3rKp3a/aGZ3a0QPW1WLtjcveQIDAQAB";

	String appPrivateKey = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDFX8Vo/J89OC43hDY+61t7XNUUoMR1uBDATThpqDwuxSq1yywFpYTIpAbJAnXi51CXpBj8etD1xZnfEeuYju/LOHXgQAU7R5wM9FOT1MIaiMJdsmXhAu6RnlOWuBlCN5M+3chEjVTT+TcAGFfA8k1N1zzTlTOF+bZQRmJoYsVcU9qBj8jM5lZLQAMBowIcZR9FxkZtdX1pKJaMV1CL3ohD3ZKkysZS025lcA/SwBqkyv1a9wUGr64F+jX7vXdwjAw3okOUH+DYGB1padgq101hoRH0HfXrMwlg8jGMHVDulmyBERoN4U2lzaZvUnHsFnJIFkI0SpJDohZ/vur/zEYVAgMBAAECggEBAJDUd+1UAh1QDknakFuXJKffNNRQLBkdmd0iTNTrCE5hi7eegI0cKdV41ynEznBTwIWlelg6Xv8ZopFXewOVT0xV/9kv4Sbgoxe2aWW+5zfFRqqub6evGRRtk3SzXoWCdl/ZKk1zT93Dr6I4OpxwsF0AJbg0cXxMAoXhP/DNGXlnHJFB1+L3XOvqZ8CS9VE5z2Msb08JNdeOYMlXiALVZVdHp7jCOKzG2Ofy96AFh1phb1eEuYK3wSmxVPWmXOaDCRIgZcehUA4kGmlH2Hbpw8F0FgcOfpCuWByQpaVTTOd9EBiSdK/gRO0Gc795QGvO56IMpFqgyCwU7oUBr86IwfkCgYEA59dUnLvmFoRfeyPJAdQAaV0/9S0nqoq3HIq3Lspx6k3LAuXc/GZk8QwYKHL1Qt4kmXQvET1pLqS/WUQHtktpijsXE+jsQjx33W+3/xHLrHesAwKF3/cE6Sxe8VVGEmepRBn0LjKeSIdMFmzl9VzgWeT+uK59jEjfzNkjq5Y7FNsCgYEA2fD8qMRWipAq0IZwN03RNTdiwTxtA41eENmwIyX5lBaPmgn6T/MZVshLGRw+V3Zen04V7xVW33KtX+lm2Uw61nOGAHNSaVhpmPFITwGMA3w49z+smp28GGr0W7m3N72sA0pSQ+co44Li9FgqwR5ZZF4WJqaOAwwNz+1n6mWzC88CgYEA282FRMvISxTZSXAWBIuwkDR+jL5w2vmEvaSuI8h/0/pJPMgdiZayoO4sgTzsVqcx3+MNNLUaYcSEPeeHwEcjGpEHQjMUu3+EzQY8VbHTfgI/rOLZdgtGNqOAqCGGu7BYBF7u6FXJR04uzxwTsVqKwe+fqAyWr0fwFtDPRsC55v0CgYEAyhr/wuXoNzEAc0XotHCWjNoi233UvlGPpOKqw72Il/rgCoIsPY37to2hjtSxP1yG3QaFsqRAXpCzFNmWRfa6LXsODkbjasvRiUJfwtx1YhoFncvPncae0qoElzc/IBLlfFuktFGeinUrUFqes14Ymcniks8rrMm12VeYYTcUdeMCgYByt8N4qMP8sKC4cmgFkygA4eUWslgMEaWaIaHWCgrZ3I32mWklWpEyXVZav5mNqLm8c2SYuDg/PEYzfIoZ32Dyf2yZnvvLvhHTPay5u/26Hpr45ofiUo4oGnhp0bzngPA5lLgQdbdpzpM8ULqFSNn0QOwoBh0amJncdz6zQLOOqQ==";

	AlipayClient alipayClient;

	public AlipayClass() {
		alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", "2016092300580762",
				appPrivateKey, "json", "UTF-8", aliPublicKey, "RSA2");
	}

	@PluginMethodAnnotation(name = "支付宝支付内容")
	public void newPayOrder(AlipayReq req, AlipayResp resp) {
		JSONObject reqJson = (JSONObject) JSON.toJSON(req);
		System.out.println("ali pay json =");
		System.out.println(reqJson.toJSONString());

		reqJson.remove("returnUrl");
		reqJson.remove("notifyUrl");
		reqJson.put("product_code", "FAST_INSTANT_TRADE_PAY");
		System.out.println(reqJson.toJSONString());

		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// 创建API对应的request
		alipayRequest.setReturnUrl(req.getReturnUrl());
		alipayRequest.setNotifyUrl(req.getNotifyUrl());// 在公共参数中设置回跳和通知地址
		alipayRequest.setBizContent(reqJson.toJSONString());// 填充业务参数
		String form = "";
		try {
			form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
			resp.setFormString(form);
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
	}

	@PluginMethodAnnotation(name = "支付宝转账")
	public void transfer(TransferReq req, TransferResp resp) {
		JSONObject reqJson = (JSONObject) JSON.toJSON(req);
		System.out.println("ali transfer json =");
		System.out.println(reqJson.toJSONString());

		reqJson.put("payee_type", "ALIPAY_LOGONID");
		System.out.println(reqJson.toJSONString());

		AlipayFundTransToaccountTransferRequest alipayRequest = new AlipayFundTransToaccountTransferRequest();// 创建API对应的request
		alipayRequest.setBizContent(reqJson.toJSONString());// 填充业务参数
		try {
			AlipayFundTransToaccountTransferResponse r = alipayClient.pageExecute(alipayRequest);
			if (r.isSuccess()) {
				resp.setResult("OK");
			} else {
				resp.setResult("ERROR");
				resp.setMsg(r.getSubMsg());
			}
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
	}

	@PluginMethodAnnotation(name = "支付宝手机支付")
	public void newWapPayOrder(AlipayReq req, AlipayResp resp) {
		JSONObject reqJson = (JSONObject) JSON.toJSON(req);
		System.out.println("ali pay json =");
		System.out.println(reqJson.toJSONString());

		reqJson.remove("returnUrl");
		reqJson.remove("notifyUrl");
		reqJson.put("product_code", "QUICK_WAP_WAY");

		AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();// 创建API对应的request
		alipayRequest.setReturnUrl(req.getReturnUrl());
		alipayRequest.setNotifyUrl(req.getNotifyUrl());// 在公共参数中设置回跳和通知地址
		alipayRequest.setBizContent(reqJson.toJSONString());// 填充业务参数
		String form = "";
		try {
			form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
			resp.setFormString(form);
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
	}

	@PluginMethodAnnotation(name = "验证支付宝通知")
	public void checkAlipayNotify(CheckAlipayNotifyReq req, CheckAlipayNotifyResp resp) {
		JSONObject ob = (JSONObject) JSON.toJSON(req);
		Map map = new HashMap();
		for (String s : ob.keySet()) {
			if (ob.get(s) != null && !ob.getString(s).equals(""))
				map.put(s, ob.get(s));
		}

		try {
			boolean result = AlipaySignature.rsaCheckV1(map, aliPublicKey, req.getCharset(), req.getSign_type());
			System.out.println("check result=" + result);

			if (result) {
				resp.setIsOk("OK");
			} else {
				resp.setIsOk("ERROR");
			}
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setIsOk("ERROR");
		}
	}

	public static void main(String[] args) {
		AlipayClass clz = new AlipayClass();
//		AlipayReq req = new AlipayReq();
//		req.setNotifyUrl("http://localhost/management/flowchart.html?processId=13");
//		req.setReturnUrl("http://localhost/management/flowchart.html?processId=13");
//		req.setOut_trade_no("1321321fdws");
//		req.setSubject("test123");
//		req.setTotal_amount("50");
//
//		AlipayResp resp = new AlipayResp();
//		clz.newWapPayOrder(req, resp);
//		System.out.println(resp.getFormString());
		
		TransferReq req=new TransferReq();
		req.setAmount("0.1");
		req.setOut_biz_no("X1235E2");
		req.setPayee_account("kacufy7481@sandbox.com");
		req.setPayee_real_name("沙箱环境");
		req.setPayer_show_name("转账");
		req.setRemark("");
		TransferResp resp=new TransferResp();
		clz.transfer(req, resp);
		System.out.println(resp.getMsg());
		System.out.println(resp.getResult());
		
		
	}

}
