package com.lin.nettyserver.http.util.string;

public abstract interface Transformer<FROM, TO> {
	public abstract TO transform(FROM paramFROM);
}
