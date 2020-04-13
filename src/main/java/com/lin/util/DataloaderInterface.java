package com.lin.util;

import stormpot.Poolable;

import java.util.Map;

public interface DataloaderInterface extends Poolable {
	public String parseValue(String pa);

	public void put(String name, Object value);

	public void putAll(Map<String, Object> object);

	public Object get(String name);

	public void destory();

	public void acquireLock();

	public void releaseLock();
}
