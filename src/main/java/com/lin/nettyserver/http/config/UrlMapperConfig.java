package com.lin.nettyserver.http.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

import com.lin.nettyserver.http.codec.HttpDecodec;

@ManagedResource(objectName = "com.lin.common:class=network,name=httpUrlMapper")
public class UrlMapperConfig {
	private Map<String, HttpDecodec> decodecMappers = new HashMap();
	private Map<String, Class> classMappers = new HashMap();

	@ManagedOperation
	public boolean contains(String url) {
		if (this.decodecMappers.containsKey(url)) {
			return true;
		}
		return false;
	}

	@ManagedOperation
	public HttpDecodec getHttpDecodec(String url) {
		return (HttpDecodec) this.decodecMappers.get(url);
	}

	@ManagedOperation
	public Class getClass(String url) {
		return (Class) this.classMappers.get(url);
	}

	public Map<String, Class> getClassMappers() {
		return this.classMappers;
	}

	public void setClassMappers(Map<String, Class> classMappers) {
		this.classMappers = classMappers;
	}

	public Map<String, HttpDecodec> getDecodecMappers() {
		return this.decodecMappers;
	}

	public void setDecodecMappers(Map<String, HttpDecodec> decodecMappers) {
		this.decodecMappers = decodecMappers;
	}

	@ManagedOperation
	public void addDecodecMapper(String url, HttpDecodec httpDecodec) {
		if (null != this.decodecMappers) {
			this.decodecMappers.put(url, httpDecodec);
		} else {
			this.decodecMappers = new HashMap();
			this.decodecMappers.put(url, httpDecodec);
		}
	}

	@ManagedOperation
	public void removeDecodecMapper(String url) {
		if (null != this.decodecMappers) {
			this.decodecMappers.remove(url);
		}
	}

	@ManagedOperation
	public void addClassMapper(String url, Class clazz) {
		if (null != this.classMappers) {
			this.classMappers.put(url, clazz);
		} else {
			this.classMappers = new HashMap();
			this.classMappers.put(url, clazz);
		}
	}

	@ManagedOperation
	public void removeClassMapper(String url) {
		if (null != this.classMappers) {
			this.classMappers.remove(url);
		}
	}
}