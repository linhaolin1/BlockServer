package com.lin.nettyserver.http.config;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jmx.export.annotation.ManagedOperation;

public class IoMapperConfig {
	private Map<Class, Object> classMapper = new HashMap();
	private Map<Class, Method> methodMapper = new HashMap();

	@ManagedOperation
	public void addClass(Class eventName, Object classObject) {
		classMapper.put(eventName, classObject);
	}

	@ManagedOperation
	public void addMethod(Class eventName, Method method) {
		methodMapper.put(eventName, method);
	}

	@ManagedOperation
	public Object getClass(Class eventName) {
		return classMapper.get(eventName);
	}

	@ManagedOperation
	public Method getMethod(Class eventName) {
		return methodMapper.get(eventName);
	}
}
