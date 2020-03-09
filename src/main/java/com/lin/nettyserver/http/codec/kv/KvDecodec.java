package com.lin.nettyserver.http.codec.kv;

import com.lin.nettyserver.http.codec.HttpDecodec;
import com.lin.nettyserver.http.util.UrlUtil;

import java.util.List;
import java.util.Map;

public class KvDecodec implements HttpDecodec<Map<String, List<Object>>> {
	private final boolean DEFAULT_INSTANCE = true;

	public <T> T decode(Map<String, List<Object>> stringObjectMap, Class<T> clazz) {
		return (T) UrlUtil.instanceObject(stringObjectMap, clazz, true);
	}
}
