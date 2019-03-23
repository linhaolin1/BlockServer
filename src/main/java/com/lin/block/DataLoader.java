package com.lin.block;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.formula.functions.T;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.lin.constants.BlockConstant;
import com.lin.entity.AbstractEntity;
import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;
import com.lin.nettyserver.http.util.string.StringConverter;
import com.lin.nettyserver.http.util.string.StringConverters;

public class DataLoader {
	public ConcurrentHashMap<String, Object> valueMap = new ConcurrentHashMap<String, Object>();

	public static Pattern textPattern = Pattern
			.compile("\\{[a-zA-Z0-9\\[\\]\\u4e00-\\u9fa5]*([.]{1}[a-zA-Z0-9\\u4e00-\\u9fa5_]+)*\\}"); // 逻辑内容匹配正则式

	public static Pattern textPattern2 = Pattern.compile("\\{[a-zA-Z0-9_]*+\\}"); // 逻辑内容匹配正则式2,用于循环填充

	public static Pattern indexPattern = Pattern.compile("\\[[0-9]+\\]"); // 位置匹配正则式

	public Object parseValue(Class type, String pa) {

		Matcher m = textPattern.matcher(pa);
		Integer st = 0, ed = 0;

		if (m.find()) { // 是否有匹配到内容
			m.reset();
		} else {
			return tranformedValue(type, pa);
		}

		while (m.find()) {
			String temp = pa.substring(ed, m.start());
			ed = m.end();
			st = m.start();
			if (temp.length() != 0)
				throw new IllegalArgumentException("not support concat");

			String temp2 = m.group();
			if (temp2.indexOf(".") == -1) {
				String sa = temp2.substring(1, temp2.length() - 1);
				return tranformedValue(type, valueMap.get(sa));
			} else if (BlockConstant.ARRAY_LENGTH.equals(temp2.substring(1, temp2.length() - 1).split("\\.")[1])) {
				String name = temp2.substring(1, temp2.length() - 1).split("\\.")[0];
				List list = (List) valueMap.get(name);
				if (list == null) {
					System.out.println(name);
				}
				return list.size();

			} else {
				String[] sa = temp2.substring(1, temp2.length() - 1).split( // 分成名称部分与值部分
						"\\.");

				Map<String, Object> ob = valueMap;
				List ar = null;
				for (Integer i = 0; i < sa.length; i++) {

					if (i == sa.length - 1) {
						Matcher mm = indexPattern.matcher(sa[i]);
						if (mm.find()) {
							String arName = sa[i].substring(0, mm.start());
							String indexString = mm.group();
							indexString = indexString.substring(1, indexString.length() - 1);
							Integer index = Integer.parseInt(indexString);
							ar = (List) ob.get(arName);
							if (ar == null) {
								System.out.println(sa[i]);
							}

							if (index >= ar.size()) {
								return null;
							} else if (ar.get(index) == null) {
								return null;
							} else {
								return tranformedValue(type, ar.get(index));
							}

						} else {
							return tranformedValue(type, ob.get(sa[i]));
						}
					} else {
						Matcher mm = indexPattern.matcher(sa[i]);
						if (mm.find()) {
							String arName = sa[i].substring(0, mm.start());
							String indexString = mm.group();
							indexString = indexString.substring(1, indexString.length() - 1);
							Integer index = Integer.parseInt(indexString);
							ar = (List) ob.get(arName);
							if (ar == null) {
								System.out.println(sa[i]);
							}

							if (index >= ar.size()) {
							} else if (ar.get(index) == null) {
							} else {
								ob = (Map<String, Object>) ar.get(index);
							}
						} else {
							ob = (Map<String, Object>) ob.get(sa[i]);
						}
					}
				}

			}
		}

		if (ed != 0 && ed != pa.length()) {
			return tranformedValue(type, pa.substring(ed, pa.length()));
		}
		return null;
	}

	public static void main(String[] args) {
		// PluginMethodParamEntity pp = new PluginMethodParamEntity();
		// pp.belong = BlockConstant.belong_request;
		// pp.realParamName = "{param1.test}";
		//
		// BlockDataLoader bl = new BlockDataLoader();
		// bl.valueMap.put(BlockConstant.belong_request, new JSONObject());
		// bl.valueMap.get(BlockConstant.belong_request).put("param1", new
		// JSONObject());
		// bl.valueMap.get(BlockConstant.belong_request).getJSONObject("param1").put("test",
		// "test2");
		// System.out.println(bl.parseText(pp));

		String s = "{name}";
		System.out.println(textPattern.matcher(s).find());

	}

	public Object tranformedValue(Class type, Object object) {
		// TODO Auto-generated method stub
		if (type.isAssignableFrom(object.getClass())) {
			return object;
		}

		if (List.class.isAssignableFrom(type)) {
			List list = new ArrayList();
			Type fc = type.getGenericSuperclass();
			if ((fc instanceof ParameterizedType)) {
				ParameterizedType pt = (ParameterizedType) fc;
				Class genericClass = (Class) pt.getActualTypeArguments()[0];
				if (genericClass.isAssignableFrom(object.getClass())) {
					list.add(object);
					return list;
				} else {

				}
			}
		} else if (Date.class.isAssignableFrom(type)) {

		} else if (Map.class.isAssignableFrom(type)) {
			HashMap map = new HashMap();
		} else if (AbstractEntity.class.isAssignableFrom(type)) {
			if (object instanceof String)
				return JSON.toJavaObject(JSON.parseObject(String.valueOf(object)), type);
		} else {
			Object value = ((StringConverter) StringConverters.getCommonFactory().transform(type))
					.transform(String.valueOf(object));
			return value;
		}

		return null;

	}

}
