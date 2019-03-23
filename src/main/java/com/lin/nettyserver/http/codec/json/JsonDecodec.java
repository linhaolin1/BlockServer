package com.lin.nettyserver.http.codec.json;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lin.nettyserver.http.codec.HttpDecodec;
import com.lin.nettyserver.http.util.JsonUtil;

public class JsonDecodec implements HttpDecodec<String> {
	private final Logger logger = LoggerFactory.getLogger(JsonDecodec.class);
	private final String CHARSET = "utf-8";

	public <T> T decode(String s, Class<T> clazz) {
		try {
			if (StringUtils.isNotEmpty(s)) {
				return (T) JsonUtil.jsonToObject(URLDecoder.decode(s, "utf-8"), clazz);
			}
			return null;
		} catch (UnsupportedEncodingException e) {
			this.logger.error("decode:{} failure.exception:{}", s, ExceptionUtils.getStackTrace(e));
		}
		return null;
	}
}