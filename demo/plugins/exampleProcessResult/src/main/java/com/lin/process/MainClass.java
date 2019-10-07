package com.lin.process;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import com.lin.block.ProcessArgument;
import com.lin.block.ProcessIntro;
import com.lin.interfacePackage.AbstractVariableParamPlugin;
import com.lin.interfacePackage.Annotation.InitParam;
import com.lin.interfacePackage.Annotation.ParamType;
import com.lin.interfacePackage.Annotation.PluginAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotationClass;
import com.lin.interfacePackage.request.VariableParamReq;
import com.lin.interfacePackage.request.VariableParamResp;
import com.lin.process.req.MD5Req;
import com.lin.process.req.Process2Req;
import com.lin.process.req.ProcessReq;
import com.lin.process.req.RedisGetReq;
import com.lin.process.req.RedisSetReq;
import com.lin.process.req.SHA1Req;
import com.lin.process.resp.MD5Resp;
import com.lin.process.resp.Process2Resp;
import com.lin.process.resp.ProcessResp;
import com.lin.process.resp.RedisGetResp;
import com.lin.process.resp.RedisSetResp;
import com.lin.process.resp.SHA1Resp;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@PluginAnnotation(name = "流程数据管理", introduce = "没什么好说的", belongType = 1)
public class MainClass extends AbstractVariableParamPlugin {

	static ConcurrentHashMap<String, JedisPool> jedisPool = new ConcurrentHashMap<String, JedisPool>();

	@InitParam
	ProcessIntro intro;

	@PluginMethodAnnotation(name = "设置数据")
	public void setResult2(Process2Req req, Process2Resp resp) {
		HashMap map = new HashMap();
		if (req.getMap() != null) {
			for (Entry<String, Object> entry : req.getMap().entrySet()) {
				String key = entry.getKey().substring(6);
				map.put("Key " + key, entry.getValue());
			}

		}
		resp.setOutMap(map);
	}

	@PluginMethodAnnotation(name = "设置分布式缓存数据")
	public void redisSet(RedisSetReq req, RedisSetResp resp) {
		String dest = req.getDestHost() + ":" + req.getPort();
		if (!jedisPool.containsKey(dest)) {
			jedisPool.put(dest, jedisPool(req.getDestHost(), Integer.parseInt(req.getPort()), req.getPass()));
		}

		Jedis jedis = jedisPool.get(dest).getResource();

		HashMap map = new HashMap();
		for (String position : req.getValueMap().keySet()) {
			String key = String.valueOf(req.getKeyMap().get("key " + position.replaceAll("([a-z]+[ ])([\\d])", "$2")));
			String value = String.valueOf(req.getValueMap().get(position));

			if (StringUtils.isBlank(key) || StringUtils.isBlank(value))
				continue;

			jedis.set(key, value);
		}
		jedis.close();

	}

	@PluginMethodAnnotation(name = "获取分布式缓存数据")
	public void redisGet(RedisGetReq req, RedisGetResp resp) {
		String dest = req.getDestHost() + ":" + req.getPort();
		if (!jedisPool.containsKey(dest)) {
			jedisPool.put(dest, jedisPool(req.getDestHost(), Integer.parseInt(req.getPort()), req.getPass()));
		}

		Jedis jedis = jedisPool.get(dest).getResource();
		resp.setResult(jedis.get(req.getKey()));
		jedis.close();
	}
	
	@PluginMethodAnnotation(name = "删除分布式缓存数据")
	public void redisDel(RedisGetReq req, RedisGetResp resp) {
		String dest = req.getDestHost() + ":" + req.getPort();
		if (!jedisPool.containsKey(dest)) {
			jedisPool.put(dest, jedisPool(req.getDestHost(), Integer.parseInt(req.getPort()), req.getPass()));
		}

		Jedis jedis = jedisPool.get(dest).getResource();
		jedis.del(req.getKey());
		jedis.close();
	}

	public JedisPool jedisPool(String host, Integer port, String pass) {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(100);
		poolConfig.setMaxIdle(20);
		poolConfig.setTestOnBorrow(true);
		poolConfig.setTestOnReturn(true);
		if (StringUtils.isBlank(pass)) {
			return new JedisPool(poolConfig, host, port, 1000);
		} else
			return new JedisPool(poolConfig, host, port, 1000, pass);
	}

	@PluginMethodAnnotation(name = "更新数据")
	public void setResult(ProcessReq req, ProcessResp resp) {
		HashMap map = new HashMap();
		if (req.getMap() != null)
			map.putAll(req.getMap());
		resp.setOutMap(map);
	}

	@PluginMethodAnnotation(name = "MD5")
	public void md5(MD5Req req, MD5Resp resp) {
		resp.setResult(encodePass(req.getParam(), PasswordType.MD5));

	}

	@PluginMethodAnnotation(name = "SHA1")
	public void sha1(SHA1Req req, SHA1Resp resp) {

		resp.setResult(encodePass(req.getString(), PasswordType.SHA1));
	}

	@Override
	public void getParams(VariableParamReq req, VariableParamResp resp) {
		List<PluginMethodParamAnnotationClass> list = new ArrayList<PluginMethodParamAnnotationClass>();
		List<PluginMethodParamAnnotationClass> list2 = new ArrayList<PluginMethodParamAnnotationClass>();
		if (req.getMethodName().equals("setResult")) {

			for (ProcessArgument pa : intro.getOutArgs()) {
				PluginMethodParamAnnotationClass clz = new PluginMethodParamAnnotationClass(pa.getName(),
						ParamType.Optional, null, null, null, "map");
				list.add(clz);

				PluginMethodParamAnnotationClass clz2 = new PluginMethodParamAnnotationClass(pa.getName(),
						ParamType.Optional, null, null, null, "outMap");
				list2.add(clz2);
			}

		} else if (req.getMethodName().equals("setResult2")) {
			try {
				Integer count = Integer.parseInt(req.getMap().get("设置数量"));
				for (int i = 1; i <= count; i++) {
					PluginMethodParamAnnotationClass clz = new PluginMethodParamAnnotationClass("Value " + i,
							ParamType.Optional, null, null, null, "map");
					list.add(clz);

					PluginMethodParamAnnotationClass clz2 = new PluginMethodParamAnnotationClass("Key " + i,
							ParamType.Optional, null, null, null, "outMap");
					list2.add(clz2);
				}

			} catch (Exception e) {

			}
		} else if (req.getMethodName().equals("redisSet")) {
			Integer count = Integer.parseInt(req.getMap().get("设置数量"));
			for (int i = 1; i <= count; i++) {
				PluginMethodParamAnnotationClass clz = new PluginMethodParamAnnotationClass("key " + String.valueOf(i),
						ParamType.Optional, null, null, null, "keyMap");
				list.add(clz);
			}
			for (int i = 1; i <= count; i++) {
				PluginMethodParamAnnotationClass clz = new PluginMethodParamAnnotationClass(
						"value " + String.valueOf(i), ParamType.Optional, null, null, null, "valueMap");
				list.add(clz);
			}
		}
		resp.setInArgs(list);
		resp.setOutArgs(list2);

		// TODO Auto-generated method stub
	}

	public enum PasswordType {
		MD5, SHA256, SHA384, SHA512, Base64, SHA1
	}

	public static String encodePass(String password, PasswordType type) {
		String newPass = null;
		if (type == PasswordType.MD5)
			newPass = DigestUtils.md5Hex(password);
		else if (type == PasswordType.SHA1)
			newPass = DigestUtils.sha1Hex(password);
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

	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println(encodePass("1q2w#E$R", PasswordType.MD5));
	}

}
