package com.lin.util;
//package com.lin.util;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import javax.script.ScriptEngine;
//import javax.script.ScriptEngineManager;
//import javax.script.ScriptException;
//
//import com.alibaba.fastjson.JSON;
//import com.lin.constants.BlockConstant;
//import com.lin.entity.AbstractEntity;
//import com.lin.nettyserver.http.util.string.StringConverter;
//import com.lin.nettyserver.http.util.string.StringConverters;
//
//public class DataLoader {
//	public ConcurrentHashMap<String, Object> valueMap = new ConcurrentHashMap<String, Object>();
//
//	public static Pattern textPattern = Pattern
//			.compile("\\{[a-zA-Z0-9\\[\\]\\u4e00-\\u9fa5]*([.]+[a-zA-Z0-9\\u4e00-\\u9fa5_]+)*\\}"); // 逻辑内容匹配正则式
//
//	public static Pattern textPattern2 = Pattern.compile("\\{[a-zA-Z0-9_\\u4e00-\\u9fa5]*+\\}"); // 逻辑内容匹配正则式2,用于循环填充
//
//	public static Pattern indexPattern = Pattern.compile("\\[[0-9]+\\]"); // 位置匹配正则式
//
//	public static Pattern sumPattern = Pattern.compile("(?i)sum\\([\\{\\}A-Z0-9a-z]\\)+"); // 位置匹配正则式
//
//	public static Pattern countPattern = Pattern.compile("(?i)count\\([\\{\\}A-Z0-9a-z]\\)+"); // 位置匹配正则式
//
//	public static void main(String[] args) throws FileNotFoundException, ScriptException {
//		// PluginMethodParamEntity pp = new PluginMethodParamEntity();
//		// pp.belong = BlockConstant.belong_request;
//		// pp.realParamName = "{param1.test}";
//		//
//		// BlockDataLoader bl = new BlockDataLoader();
//		// bl.valueMap.put(BlockConstant.belong_request, new JSONObject());
//		// bl.valueMap.get(BlockConstant.belong_request).put("param1", new
//		// JSONObject());
//		// bl.valueMap.get(BlockConstant.belong_request).getJSONObject("param1").put("test",
//		// "test2");
//		// System.out.println(bl.parseText(pp));
//		// Pattern countPattern2 =
//		// Pattern.compile("(?i)count\\([\\{\\}A-Z0-9a-z.]+\\)");
////		List ar = new ArrayList();
////		ar.add("1");
////		ar.add("2");
////
////		DataLoader dl = new DataLoader();
////		dl.valueMap.put("账号", "123");
////		dl.valueMap.put("时间", new Date());
////		dl.valueMap.put("array", ar);
////		String s = "{账号}{时间}";
////
////		System.out.println(dl.parseValue(String.class, s));
//
//		 ScriptEngineManager sem = new ScriptEngineManager();
//		 ScriptEngine engine = sem.getEngineByName("JavaScript");
//		 String jsFileName = "e:\\test.js"; // 读取js文件
//		
//		 FileReader reader;
//		
//		 reader = new FileReader(jsFileName);
//		
//		 engine.eval(reader);
//		 String s=String.valueOf(engine.eval("new Date().getTime().toFixed()"));
//		 
//				 
//				 
//		 System.out.println(s);
//
//	}
//
//	public int count(Object ob) {
//		if (ob == null) {
//			return 0;
//		} else if (List.class.isAssignableFrom(ob.getClass())) {
//			List list = (List) ob;
//			return list.size();
//
//		} else if (Map.class.isAssignableFrom(ob.getClass())) {
//			Map map = (Map) ob;
//			return map.size();
//		} else
//			return 1;
//	}
//
//	public Double sum(Object ob, String name) {
//		Double sum = 0.0;
//		if (List.class.isAssignableFrom(ob.getClass())) {
//			List list = (List) ob;
//			for (Object single : list) {
//				sum += getNumericValue(single, name);
//			}
//
//		} else if (Map.class.isAssignableFrom(ob.getClass())) {
//			Map map = (Map) ob;
//
//		}
//		return sum;
//	}
//
//	public Double getNumericValue(Object ob, String name) {
//		return Double.parseDouble(String.valueOf(ob));
//	}
//
//	public String parseCountValue(String pa) {
//		StringBuilder newString = new StringBuilder();
//
//		Matcher m = sumPattern.matcher(pa);
//		if (m.find()) { // 是否有匹配到内容
//			m.reset();
//		} else {
//			return pa;
//		}
//
//		Integer st = 0, ed = 0;
//		while (m.find()) {
//			String temp = pa.substring(ed, m.start());
//			newString.append(temp);
//			ed = m.end();
//			st = m.start();
//
//			String temp2 = m.group();
//
//			String string = temp2.substring("count(".length(), temp.length() - 1);
//
//			Object ob = parseNormalValue(string);
//			String result = String.valueOf(count(ob));
//			newString.append(result);
//		}
//
//		if (ed != 0 && ed != pa.length()) {
//			newString.append(pa.substring(ed, pa.length()));
//		}
//
//		return newString.toString();
//
//	}
//
//	public String parseSumValue(String pa) {
//		StringBuilder newString = new StringBuilder();
//		Matcher m = sumPattern.matcher(pa);
//		if (m.find()) { // 是否有匹配到内容
//			m.reset();
//		} else {
//			return pa;
//		}
//
//		Integer st = 0, ed = 0;
//		while (m.find()) {
//			String temp = pa.substring(ed, m.start());
//			newString.append(temp);
//			ed = m.end();
//			st = m.start();
//
//			String temp2 = m.group();
//
//			String string = temp2.substring("sum(".length(), temp.length() - 1);
//			String key = string.split(",")[0];
//			String name = string.split(",")[1];
//
//			Object ob = parseNormalValue(key);
//			String result = String.valueOf(sum(ob, name));
//			newString.append(result);
//		}
//
//		if (ed != 0 && ed != pa.length()) {
//			newString.append(pa.substring(ed, pa.length()));
//		}
//
//		return newString.toString();
//
//	}
//
//	private Object getValue(String key) {
//		Matcher m = textPattern.matcher(key);
//		if (m.find()) { // 是否有匹配到内容
//			m.reset();
//		} else {
//			return tranformedValue(String.class, key);
//		}
//
//		if (key.indexOf(".") == -1) {
//			String sa = key.substring(1, key.length() - 1);
//			return valueMap.get(sa);
//		} else if (BlockConstant.ARRAY_LENGTH.equals(key.substring(1, key.length() - 1).split("\\.")[1])) {
//			String name = key.substring(1, key.length() - 1).split("\\.")[0];
//			List list = (List) valueMap.get(name);
//			if (list == null) {
//				System.out.println(name);
//			}
//			return list.size();
//
//		} else {
//			String[] sa = key.substring(1, key.length() - 1).split( // 分成名称部分与值部分
//					"\\.");
//			Map<String, Object> ob = valueMap;
//			List ar = null;
//			for (Integer i = 0; i < sa.length; i++) {
//
//				if (i == sa.length - 1) {
//					Matcher mm = indexPattern.matcher(sa[i]);
//					if (mm.find()) {
//						String arName = sa[i].substring(0, mm.start());
//						String indexString = mm.group();
//						indexString = indexString.substring(1, indexString.length() - 1);
//						Integer index = Integer.parseInt(indexString);
//						ar = (List) ob.get(arName);
//						if (ar == null) {
//							System.out.println(sa[i]);
//						}
//
//						if (index >= ar.size()) {
//							return null;
//						} else if (ar.get(index) == null) {
//							return null;
//						} else {
//							return ar.get(index);
//						}
//
//					} else {
//						return ob.get(sa[i]);
//					}
//				} else {
//					Matcher mm = indexPattern.matcher(sa[i]);
//					if (mm.find()) {
//						String arName = sa[i].substring(0, mm.start());
//						String indexString = mm.group();
//						indexString = indexString.substring(1, indexString.length() - 1);
//						Integer index = Integer.parseInt(indexString);
//						ar = (List) ob.get(arName);
//						if (ar == null) {
//							System.out.println(sa[i]);
//						}
//
//						if (index >= ar.size()) {
//						} else if (ar.get(index) == null) {
//
//						} else {
//							ob = (Map<String, Object>) ar.get(index);
//						}
//					} else {
//						ob = (Map<String, Object>) ob.get(sa[i]);
//					}
//				}
//			}
//		}
//
//		return null;
//
//	}
//
//	public String parseNormalValue(String pa) {
//
//		StringBuilder sb = new StringBuilder();
//
//		Matcher m = textPattern2.matcher(pa);
//		Integer st = 0, ed = 0;
//
//		if (m.find()) { // 是否有匹配到内容
//			m.reset();
//		} else {
//			return pa;
//		}
//
//		while (m.find()) {
//			String temp = pa.substring(ed, m.start());
//			sb.append(temp);
//			ed = m.end();
//			st = m.start();
//
//			Object object = getValue(m.group());
//			if (object instanceof String) {
//				sb.append(object);
//			} else {
//				sb.append(JSON.toJSONString(object));
//			}
//		}
//
//		if (ed != 0 && ed != pa.length()) {
//			sb.append(pa.substring(ed, pa.length()));
//		}
//		String value = sb.toString();
//		return parseNormalValue(value);
//	}
//
//	public String parseValue(String pa) {
//		return String.valueOf(parseValue(String.class, pa));
//	}
//
//	public Object parseValue(Class type, String pa) {
//		try {
//			// 函数处理
//			// COUNT
//			// SUM
//			// 调用JS！
//			ScriptEngineManager sem = new ScriptEngineManager();
//			ScriptEngine engine = sem.getEngineByName("JavaScript");
//			String jsFileName = "e:\\test.js"; // 读取js文件
//
//			FileReader reader;
//			reader = new FileReader(jsFileName);
//			engine.eval(reader);
//
//			// 转化{}和普通字符串
//			pa = parseNormalValue(pa);
//			String s = null;
//
//			if (pa.toLowerCase().startsWith("count(") || pa.toLowerCase().startsWith("sum(")
//					|| pa.toLowerCase().startsWith("val(")) {
//				try {
//					s = JSON.toJSONString(engine.eval(pa));
//				} catch (ScriptException se) {
//					s = JSON.toJSONString(engine.eval("\"" + pa + "\""));
//				}
//			} else {
//				s = pa;
//			}
//			// pa = parseFourOperation(type, pa);
//			while(s.startsWith("\"")&&s.endsWith("\"")){
//				s=s.substring(1, s.length()-1);
//			}
//			
//			return s;
//		} catch (FileNotFoundException |
//
//				ScriptException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} // 执行指定脚本
//		return null;
//	}
//
//	public Object tranformedValue(Class type, Object object) {
//		// TODO Auto-generated method stub
//		if (type.isAssignableFrom(object.getClass())) {
//			return object;
//		}
//
//		if (List.class.isAssignableFrom(type)) {
//			List list = new ArrayList();
//			Type fc = type.getGenericSuperclass();
//			if ((fc instanceof ParameterizedType)) {
//				ParameterizedType pt = (ParameterizedType) fc;
//				Class genericClass = (Class) pt.getActualTypeArguments()[0];
//				if (genericClass.isAssignableFrom(object.getClass())) {
//					list.add(object);
//					return list;
//				} else {
//
//				}
//			}
//		} else if (Date.class.isAssignableFrom(type)) {
//
//		} else if (Map.class.isAssignableFrom(type)) {
//			HashMap map = new HashMap();
//		} else if (AbstractEntity.class.isAssignableFrom(type)) {
//			if (object instanceof String)
//				return JSON.toJavaObject(JSON.parseObject(String.valueOf(object)), type);
//		} else {
//			Object value = ((StringConverter) StringConverters.getCommonFactory().transform(type))
//					.transform(String.valueOf(object));
//			return value;
//		}
//
//		return null;
//
//	}
//
//}
