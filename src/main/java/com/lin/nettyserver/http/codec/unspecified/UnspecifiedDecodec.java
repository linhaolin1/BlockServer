package com.lin.nettyserver.http.codec.unspecified;

import com.lin.nettyserver.http.codec.HttpDecodec;

public class UnspecifiedDecodec implements HttpDecodec<String> {
	private final boolean DEFAULT_INSTANCE = true;

	public <T> T decode(String body, Class<T> clazz) {
		return null;
	}

}
