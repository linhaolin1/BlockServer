package com.lin.util;

import stormpot.Poolable;

import java.util.Map;
import java.util.regex.Pattern;

public interface DataloaderInterface extends Poolable {
	public static Pattern textPattern = Pattern
			.compile("\\{[a-zA-Z0-9_\\[\\]\\u4e00-\\u9fa5]*([.]+[a-zA-Z0-9_\\u4e00-\\u9fa5_]+)*\\}"); // 逻辑内容匹配正则式

	public static Pattern textPattern2 = Pattern.compile("\\{[a-zA-Z0-9_.\\u4e00-\\u9fa5]*+\\}"); // 逻辑内容匹配正则式2,用于循环填充


	public Object parseValue(String pa);

	public void put(String name, Object value);

	public void putAll(Map<String, Object> object);

	public Object get(String name);

	public void destory();

	public void acquireLock();

	public void releaseLock();
}
