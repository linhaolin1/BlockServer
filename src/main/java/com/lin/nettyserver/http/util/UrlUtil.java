package com.lin.nettyserver.http.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.lin.entity.AbstractEntity;
import com.lin.nettyserver.http.annotation.KvField;
import com.lin.nettyserver.http.util.string.StringConverter;
import com.lin.nettyserver.http.util.string.StringConverters;

import io.netty.handler.codec.http.QueryStringDecoder;

public class UrlUtil {
	private static final Logger logger = LoggerFactory.getLogger(UrlUtil.class);

	public static String objectToUrl(Object o) throws IllegalAccessException {

		Field[] fields = o.getClass().getDeclaredFields();
		StringBuffer buffer = new StringBuffer();
		if (null != fields) {
			for (Field field : fields) {
				if (field.isAnnotationPresent(KvField.class)) {
					KvField kvField = (KvField) field.getAnnotation(KvField.class);
					field.setAccessible(true);
					Object value = field.get(o);
					if (null != value) {
						if (List.class.isAssignableFrom(field.getType())) {
							List list = (List) value;
							for (Object v : list) {
								if (buffer.length() == 0) {
									buffer.append(kvField.key()).append("=").append(v);
								} else {
									buffer.append("&").append(kvField.key()).append("=").append(v);
								}
							}
						} else if (buffer.length() == 0) {
							buffer.append(kvField.key()).append("=").append(value);
						} else {
							buffer.append("&").append(kvField.key()).append("=").append(value);
						}
					}
				}
			}
			return buffer.toString();
		}
		return "";
	}

	public static Map parseXmlParam(String docString) {
		Document document = null;
		try {
			document = DocumentHelper.parseText(docString);
		} catch (DocumentException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Map<String, Object> params = new LinkedHashMap();
		List<Element> els = document.getRootElement().elements();
		for (Element e : els) {
			if (e.elements().size() > 0) {
				for (Element el : e.elements()) {
					Object ob = elementObject(el);
					List<Object> list = null;
					if (params.containsKey(e.getName())) {
						list = (List<Object>) params.get(el.getName());
						list.add(ob);
					} else {
						list = new ArrayList<Object>();
						list.add(ob);
						params.put(el.getName(), list);
					}
				}
			} else {
				List<String> list = null;
				if (params.containsKey(e.getName())) {
					list = (List<String>) params.get(e.getName());
					list.add(e.getStringValue());
				} else {
					list = new ArrayList<String>();
					list.add(e.getStringValue());
					params.put(e.getName(), list);
				}
			}
		}
		return params;
	}

	private static Object elementObject(Element element) {
		if (element.elements().size() > 0) {
			Map<String, List<Object>> params = new LinkedHashMap<String, List<Object>>();
			for (Element e : element.elements()) {
				Object ob = elementObject(e);
				List<Object> list = null;
				if (params.containsKey(e.getName())) {
					list = (List<Object>) params.get(e.getName());
					list.add(ob);
				} else {
					list = new ArrayList<Object>();
					list.add(ob);
					params.put(e.getName(), list);
				}
			}
			return params;
		} else {
			return element.getStringValue();
		}
	}

	public static <T> T instanceObject(Map<String, List<Object>> params, Class<T> className, boolean defaultInstance) {
		if (null == params) {
			if (defaultInstance) {
				try {
					return (T) className.newInstance();
				} catch (InstantiationException e) {
					return null;
				} catch (IllegalAccessException e) {
					return null;
				}
			}
			return null;
		}
		try {
			T t = className.newInstance();

			Field[] fileds = className.getDeclaredFields();
			if ((null == fileds) || (fileds.length == 0)) {
				return t;
			}
			if (!params.isEmpty()) {
				for (Field field : fileds) {
					String annotationKey = getKey(field);
					field.setAccessible(true);
					if (null != annotationKey) {
						List<Object> values = (List) params.get(annotationKey);
						if ((null != values) && (values.size() > 0)) {
							if (List.class.isAssignableFrom(field.getType())) {
								List list = new ArrayList();
								Type fc = field.getGenericType();
								if ((fc instanceof ParameterizedType)) {
									ParameterizedType pt = (ParameterizedType) fc;
									Class genericClass = (Class) pt.getActualTypeArguments()[0];
									for (Object value : values) {
										Object o = ((StringConverter) StringConverters.getCommonFactory()
												.transform(genericClass)).transform(String.valueOf(value));
										list.add(o);
									}
									field.set(t, list);
								}
							} else if (values.get(0).getClass().isArray()){
								field.set(t, values.get(0));
							}else {
								Object value = ((StringConverter) StringConverters.getCommonFactory()
										.transform(field.getType())).transform(String.valueOf(values.get(0)));
								field.set(t, value);
							}
						}
					}
				}
			}
			return t;
		} catch (InstantiationException e) {
			logger.error("kv to object error.exception:", e.fillInStackTrace());
		} catch (IllegalAccessException e) {
			logger.error("kv to object error.exception:", e.fillInStackTrace());
		}
		return null;
	}

	private static String getKey(Field field) {
		if (field.isAnnotationPresent(KvField.class)) {
			KvField kv = (KvField) field.getAnnotation(KvField.class);
			if (StringUtils.isEmpty(kv.key())) {
				return field.getName();
			} else
				return kv.key();
		}
		return null;
	}

	public static Map<String, List<String>> decodeParams(String s, Charset charset) {
		Map<String, List<String>> params = new LinkedHashMap<String, List<String>>();

		String name = null;
		int pos = 0; // Beginning of the unprocessed region
		int i; // End of the unprocessed region
		char c; // Current character
		for (i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (c == '=' && name == null) {
				if (pos != i) {
					name = decodeComponent(s.substring(pos, i), charset);
				}
				pos = i + 1;
				// http://www.w3.org/TR/html401/appendix/notes.html#h-B.2.2
			} else if (c == '&' || c == ';') {
				if (name == null && pos != i) {
					// We haven't seen an `=' so far but moved forward.
					// Must be a param of the form '&a&' so add it with
					// an empty value.
					if (!addParam(params, decodeComponent(s.substring(pos, i), charset), "")) {
					}
				} else if (name != null) {
					if (!addParam(params, name, decodeComponent(s.substring(pos, i), charset))) {
					}
					name = null;
				}
				pos = i + 1;
			}
		}

		if (pos != i) { // Are there characters we haven't dealt with?
			if (name == null) { // Yes and we haven't seen any `='.
				addParam(params, decodeComponent(s.substring(pos, i), charset), "");
			} else { // Yes and this must be the last value.
				addParam(params, name, decodeComponent(s.substring(pos, i), charset));
			}
		} else if (name != null) { // Have we seen a name without value?
			addParam(params, name, "");
		}
		return params;
	}

	private static String decodeComponent(String s, Charset charset) {
		return QueryStringDecoder.decodeComponent(s, charset);
	}

	private static boolean addParam(Map<String, List<String>> params, String name, String value) {

		List<String> values = params.get(name);
		if (values == null) {
			values = new ArrayList<String>(1); // Often there's only 1 value.
			params.put(name, values);
		}
		values.add(value);
		return true;
	}
}