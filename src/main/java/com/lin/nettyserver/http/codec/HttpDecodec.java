package com.lin.nettyserver.http.codec;

public abstract interface HttpDecodec<IN> {
	public abstract <T> T decode(IN paramIN, Class<T> paramClass);
}
