package com.lin.nettyserver.http.codec.kv;

import java.util.List;
import java.util.Map;

import com.lin.nettyserver.http.codec.HttpDecodec;
import com.lin.nettyserver.http.util.UrlUtil;

public class KvDecodec implements HttpDecodec<Map<String, List<String>>> {
	private final boolean DEFAULT_INSTANCE = true;

	public <T> T decode(Map<String, List<String>> stringObjectMap, Class<T> clazz) {
		return (T) UrlUtil.instanceObject(stringObjectMap, clazz, true);
	}
}
