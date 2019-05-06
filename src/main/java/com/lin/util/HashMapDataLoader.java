package com.lin.util;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.lin.constants.BlockConstant;

public class HashMapDataLoader implements DataloaderInterface {
	public ConcurrentHashMap<String, Object> valueMap = new ConcurrentHashMap<String, Object>();

	public static Pattern textPattern = Pattern
			.compile("\\{[[a-zA-Z0-9\\u4e00-\\u9fa5]*\\[0-9\\]+[.]{1}]*[a-zA-Z0-9\\u4e00-\\u9fa5_]{1}\\}"); // 逻辑内容匹配正则式

	// public static Pattern textPattern2 =
	// Pattern.compile("\\{[a-zA-Z0-9_]*+\\}"); // 逻辑内容匹配正则式2,用于循环填充

	public static Pattern indexPattern = Pattern.compile("\\[[0-9]+\\]"); // 位置匹配正则式

	public static Pattern sumPattern = Pattern.compile("(?i)sum\\([\\{\\}A-Z0-9a-z]\\)+"); // 位置匹配正则式

	public static Pattern countPattern = Pattern.compile("(?i)count\\([\\{\\}A-Z0-9a-z]\\)+"); // 位置匹配正则式

	public ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

	public HashMapDataLoader(String jsFileName) {
		try {
			List<String> array = Files.readAllLines(Paths.get(jsFileName));
			StringBuilder sb = new StringBuilder();
			for (String s : array) {
				sb.append(s + "\n");
			}
			engine.eval(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		// Pattern countPattern2 =
		// Pattern.compile("(?i)count\\([\\{\\}A-Z0-9a-z.]+\\)");
		// String s = "Count({name.123})";
		// System.out.println(countPattern2.matcher(s).find());

		HashMap map = new HashMap();
		map.put("商品数量", 1);
		map.put("price", 2);

		List ar = new ArrayList();
		ar.add("1");
		ar.add("2");
		ar.add(map);
		ar.add(null);
		System.out.println(ar.size());
//
		HashMapDataLoader dl = new HashMapDataLoader("e:\\test.js");
		dl.put("账号", "123");
		dl.put("时间", new Date());
		dl.put("array", ar);
		dl.put("账号123", "321");
		String s = "{array}[2].price*{array}[2].商品数量+{账号}";

		System.out.println(dl.parseValue(s));
		System.out.println(dl.parseValue("{账号{账号}}"));
	}

	public int count(Object ob) {
		if (ob == null) {
			return 0;
		} else if (List.class.isAssignableFrom(ob.getClass())) {
			List list = (List) ob;
			return list.size();

		} else if (Map.class.isAssignableFrom(ob.getClass())) {
			Map map = (Map) ob;
			return map.size();
		} else
			return 1;
	}

	public Double sum(Object ob, String name) {
		Double sum = 0.0;
		if (List.class.isAssignableFrom(ob.getClass())) {
			List list = (List) ob;
			for (Object single : list) {
				sum += getNumericValue(single, name);
			}

		} else if (Map.class.isAssignableFrom(ob.getClass())) {
			Map map = (Map) ob;

		}
		return sum;
	}

	public Double getNumericValue(Object ob, String name) {
		return Double.parseDouble(String.valueOf(ob));
	}

	public String parseCountValue(String pa) {
		StringBuilder newString = new StringBuilder();

		Matcher m = sumPattern.matcher(pa);
		Integer st = 0, ed = 0;

		if (m.find()) {
			m.reset();
		} else {
			return pa;
		}

		while (m.find()) {
			String temp = pa.substring(ed, m.start());
			newString.append(temp);
			ed = m.end();
			st = m.start();

			String temp2 = m.group();

			String string = temp2.substring("count(".length(), temp.length() - 1);

			Object ob = parseNormalValue(string);
			String result = String.valueOf(count(ob));
			newString.append(result);
		}

		if (ed != 0 && ed != pa.length()) {
			newString.append(pa.substring(ed, pa.length()));
		}

		return newString.toString();

	}

	public String parseSumValue(String pa) {
		StringBuilder newString = new StringBuilder();

		Matcher m = sumPattern.matcher(pa);
		Integer st = 0, ed = 0;

		if (m.find()) {
			m.reset();
		} else {
			return pa;
		}

		while (m.find()) {
			String temp = pa.substring(ed, m.start());
			newString.append(temp);
			ed = m.end();
			st = m.start();

			String temp2 = m.group();

			String string = temp2.substring("sum(".length(), temp.length() - 1);
			String key = string.split(",")[0];
			String name = string.split(",")[1];

			Object ob = parseNormalValue(key);
			String result = String.valueOf(sum(ob, name));
			newString.append(result);
		}

		if (ed != 0 && ed != pa.length()) {
			newString.append(pa.substring(ed, pa.length()));
		}

		return newString.toString();

	}

	private Object getValue(String key) {

		Matcher m = textPattern.matcher(key);
		if (m.find()) { // 是否有匹配到内容
			m.reset();
		} else {
			return tranformedValue(key);
		}

		if (key.indexOf(".") == -1) {
			String sa = key.substring(1, key.length() - 1);
			return valueMap.get(sa);
		} else if (BlockConstant.ARRAY_LENGTH.equals(key.substring(1, key.length() - 1).split("\\.")[1])) {
			String name = key.substring(1, key.length() - 1).split("\\.")[0];
			List list = (List) valueMap.get(name);
			if (list == null) {
				System.out.println(name);
			}
			return list.size();

		} else {
			String[] sa = key.substring(1, key.length() - 1).split( // 分成名称部分与值部分
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
							return ar.get(index);
						}

					} else {
						return ob.get(sa[i]);
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

		return null;

	}

	public String parseNormalValue(String pa) {

		StringBuilder sb = new StringBuilder();

		Matcher m = textPattern.matcher(pa);
		Integer st = 0, ed = 0;

		if (m.find()) { // 是否有匹配到内容
			m.reset();
		} else {
			return pa;
		}

		while (m.find()) {
			String temp = pa.substring(ed, m.start());
			sb.append(temp);
			ed = m.end();
			st = m.start();

			Object object = getValue(m.group());
			if (object instanceof String) {
				sb.append(object);
			} else {
				sb.append(JSON.toJSONString(object));
			}
		}

		if (ed != 0 && ed != pa.length()) {
			sb.append(pa.substring(ed, pa.length()));
		}
		String value = sb.toString();
		return parseNormalValue(value);
	}

	public String parseValue(String pa) {

		// 函数处理
		// COUNT
		// SUM

		// pa = parseSumValue(pa);
		// pa = parseCountValue(pa);
		pa = parseNormalValue(pa);
		return tranformedValue(pa);
	}

	private boolean isNeedJs(String pa) {
		boolean fourFundamental = false;
		if (pa.indexOf("+") > 0 || pa.indexOf("-") > 0 || pa.indexOf("*") > 0 || pa.indexOf("/") > 0) {
			fourFundamental = true;
		}

		if (pa.indexOf("count(") != -1 || pa.indexOf("sum(") != -1 || pa.indexOf("arrayValue(") != -1
				|| pa.indexOf("val(") != -1 || pa.indexOf("formatTime(") != -1 || fourFundamental || pa.startsWith("[")
				|| pa.startsWith("{")) {
			return true;
		}
		return false;
	}

	public String tranformedValue(String object) {
		// TODO Auto-generated method stub

		if (StringUtils.isBlank(object))
			return "";

		System.out.println("load value:" + object);
		System.out.println("isNeedJs:" + isNeedJs(object));
		if (!isNeedJs(object))
			return object;

		try {
			String type = (String) engine.eval("typeof(" + object + ")");
			if (type.equals("object")) {
				return String.valueOf(engine.eval("JSON.stringify(" + object + ")"));
			} else if (type.equals("undefined")) {
				return "";
			} else {
				return String.valueOf(engine.eval(object));
			}
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";

		// if (type.isAssignableFrom(object.getClass())) {
		// return object;
		// }
		//
		// if (List.class.isAssignableFrom(type)) {
		// List list = new ArrayList();
		// Type fc = type.getGenericSuperclass();
		// if ((fc instanceof ParameterizedType)) {
		// ParameterizedType pt = (ParameterizedType) fc;
		// Class genericClass = (Class) pt.getActualTypeArguments()[0];
		// if (genericClass.isAssignableFrom(object.getClass())) {
		// list.add(object);
		// return list;
		// } else {
		//
		// }
		// }
		// } else if (Date.class.isAssignableFrom(type)) {
		//
		// } else if (Map.class.isAssignableFrom(type)) {
		// HashMap map = new HashMap();
		// } else if (AbstractEntity.class.isAssignableFrom(type)) {
		// if (object instanceof String)
		// return JSON.toJavaObject(JSON.parseObject(String.valueOf(object)),
		// type);
		// } else {
		// Object value = ((StringConverter)
		// StringConverters.getCommonFactory().transform(type))
		// .transform(String.valueOf(object));
		// return value;
		// }
		//
		// return null;

	}

	@Override
	public void put(String name, Object value) {
		// TODO Auto-generated method stub
		try {

			Map map = valueMap;
			String[] splitByDot = name.split("\\.");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < splitByDot.length - 1; i++) {
				String dot = splitByDot[i];

				Matcher ma = BlockConstant.PATTERN_NAME_ARRAY.matcher(dot);
				while (ma.find()) {
					String group = ma.group();
					Matcher ma2 = BlockConstant.PATTERN_NAME_ARRAY_POSITION.matcher(group);
					ma2.find();
					while (true) {
						String preName = dot.substring(0, ma.start() + ma2.start());
						List list = null;

						if (get(preName) == null) {
							list = new ArrayList();
							map.put(preName, list);
						} else {
							list = (List) map.get(preName);
						}

						String position = ma2.group();
						position = position.substring(1, position.length() - 1);
						int pos = Integer.parseInt(position);
						if (ma2.find()) {
							while (list.size() < (pos - 1)) {
								list.add(null);
							}

							list = (List) list.get(Integer.parseInt(position));
						} else {
							break;
						}

					}
				}

				sb.append(dot);
				if ("true".equals(String.valueOf(engine.eval("typeof " + sb.toString() + "=='undefined'")))) {
					engine.eval(sb.toString() + " = {}");
				}
				sb.append(".");
			}

			if (value instanceof String) {
				String valString = (String) value;
				valString = valString.replace("\n", "");
				if (valString.startsWith("[") || valString.startsWith("{") || valString.startsWith("\"")) {
					valueMap.put(name, valString);
				} else {
					if (valString.indexOf("\"") != -1 && valString.indexOf("") == -1) {
						engine.eval(name + "='" + valString + "'");
					} else if (valString.indexOf("'") != -1 && valString.indexOf("\"") == -1) {
						engine.eval(name + "=\"" + valString + "\"");
					} else if (valString.indexOf("'") != -1 && valString.indexOf("\"") != -1) {
						engine.eval(name + "=\"" + valString.replace("\"", "\\\"") + "\"");
					} else {
						engine.eval(name + "='" + valString + "'");
					}
				}
			} else {
				engine.eval(name + "=" + JSON.toJSONString(value));
			}

			// keys.add(name);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			System.out.println(" put exception ");
			System.out.println(name);
			System.out.println(value);
			e.printStackTrace();
		}

	}

	@Override
	public void putAll(Map<String, Object> object) {
		// TODO Auto-generated method stub
		if (object != null && object.size() > 0)
			for (Entry<String, Object> o : object.entrySet()) {
				put(o.getKey(), o.getValue());
			}
	}

	@Override
	public Object get(String name) {
		// TODO Auto-generated method stub

		return parseValue(name);
	}

	@Override
	public void destory() {
		// TODO Auto-generated method stub
		
	}

}
