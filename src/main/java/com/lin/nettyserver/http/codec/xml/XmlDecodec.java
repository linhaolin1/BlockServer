package com.lin.nettyserver.http.codec.xml;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.lin.nettyserver.http.codec.HttpDecodec;
import com.lin.nettyserver.http.util.UrlUtil;

public class XmlDecodec implements HttpDecodec<String> {
	private final boolean DEFAULT_INSTANCE = true;

	public <T> T decode(String body, Class<T> clazz) {
		Map<String, Object> params = UrlUtil.parseXmlParam(body);
		return (T) JSON.parseObject(JSON.toJSONString(params), clazz);

	}

}
