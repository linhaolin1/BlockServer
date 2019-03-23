package com.lin.util;

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

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class EncryptUtil {

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
}
