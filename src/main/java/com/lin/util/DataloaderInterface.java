package com.lin.util;

import java.util.Map;

public interface DataloaderInterface {
	public String parseValue(String pa);

	public void put(String name, Object value);

	public void putAll(Map<String, Object> object);

	public Object get(String name);
}
