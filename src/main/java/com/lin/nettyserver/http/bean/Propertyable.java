package com.lin.nettyserver.http.bean;

import java.util.HashMap;
import java.util.Map;

import com.lin.nettyserver.http.statistic.Statisable;

public abstract class Propertyable implements Statisable {
	private Map<String, Object> properties = new HashMap();
	private final long timeMillis = System.currentTimeMillis();

	public void setProperty(String key, Object value) {
		this.properties.put(key, value);
	}

	public Object getProperty(String key) {
		return this.properties.get(key);
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	public long getTimeMillis() {
		return this.timeMillis;
	}
}