package com.lin.nettyserver.http.util;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	private static final ObjectMapper objectMapper = new ObjectMapper();

	static {
		objectMapper.getDeserializationConfig().with(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}

	public static String objectToJson(Object o) {
		if (null == o) {
			return null;
		}
		try {
			return objectMapper.writeValueAsString(o);
		} catch (Exception e) {
			logger.error("objectToJson:{} failure.exception:{}", o, ExceptionUtils.getStackTrace(e));
		}
		return null;
	}

	public static <T> T jsonToObject(String json, Class<T> clazz) {
		try {
			return (T) JSON.toJavaObject((JSON) JSON.parse(json), clazz);
		} catch (Exception e) {
			return null;
		}

		// try {
		// if (StringUtils.isEmpty(json)) {
		// return null;
		// }
		// return (T) objectMapper.readValue(json, clazz);
		// } catch (Exception e) {
		// logger.error("json:{} to object error.exception:", json,
		// ExceptionUtils.getStackTrace(e));
		// }
		// return null;
	}
}