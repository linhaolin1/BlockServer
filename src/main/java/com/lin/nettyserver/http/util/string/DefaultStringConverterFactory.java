package com.lin.nettyserver.http.util.string;

import java.util.HashMap;
import java.util.Map;

public class DefaultStringConverterFactory implements Transformer<Class<?>, StringConverter> {
	public StringConverter transform(Class<?> aClass) {
		return (StringConverter) this.converters.get(aClass);
	}

	private Map<Class<?>, StringConverter> converters = new HashMap();

	public void setConverters(Map<Class<?>, StringConverter> converters) {
		this.converters.clear();
		for (Map.Entry<Class<?>, StringConverter> entry : converters.entrySet()) {
			if (null != entry.getValue()) {
				this.converters.put(entry.getKey(), entry.getValue());
			}
		}
	}

	public DefaultStringConverterFactory setConverter(Class<?> cls, StringConverter converter) {
		this.converters.put(cls, converter);
		return this;
	}
}
