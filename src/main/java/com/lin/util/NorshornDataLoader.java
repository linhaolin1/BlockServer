package com.lin.util;

import com.alibaba.fastjson.JSON;
import com.lin.constants.BlockConstant;
import com.lin.entity.AbstractEntity;
import com.lin.nettyserver.http.util.string.StringConverter;
import com.lin.nettyserver.http.util.string.StringConverters;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class NorshornDatdeLoader implements DataloaderInterface{
	// public ConcurrentHashMap<String, Object> valueMap = new
	// ConcurrentHashMap<String, Object>();

	static ScriptEngine engine;

	private List<String> keys = new ArrayList<String>();

	public static Pattern textPattern = Pattern
			.compile("\\{[a-zA-Z0-9_\\[\\]\\u4e00-\\u9fa5]*([.]+[a-zA-Z0-9_\\u4e00-\\u9fa5_]+)*\\}"); // 逻辑内容匹配正则式

	public static Pattern textPattern2 = Pattern.compile("\\{[a-zA-Z0-9_\\u4e00-\\u9fa5]*+\\}"); // 逻辑内容匹配正则式2,用于循环填充

	public static Pattern indexPattern = Pattern.compile("\\[[0-9]+\\]"); // 位置匹配正则式

	public static Pattern sumPattern = Pattern.compile("(?i)sum\\([\\{\\}A-Z0-9a-z_]\\)+"); // 位置匹配正则式

	public static Pattern countPattern = Pattern.compile("(?i)count\\([\\{\\}A-Z0-9a-z_]\\)+"); // 位置匹配正则式

	public NorshornDatdeLoader(String filePath) {
		if(engine!=null)
			return;
		
		ScriptEngineManager sem = new ScriptEngineManager();
		engine = sem.getEngineByName("nashorn");
		String jsFileName = filePath; // 读取js文件

		System.out.println("jspath=" + jsFileName);

		try {
			List<String> array=Files.readAllLines(Paths.get(jsFileName));
			StringBuilder sb=new StringBuilder();
			for(String s:array){
				sb.append(s+"\n");
			}
			engine.eval(sb.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ScriptException e) {
			// TODO Auto-generated catch block0
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws FileNotFoundException, ScriptException {
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
		// List ar = new ArrayList();
		// ar.add("1");
		// ar.add("2");
		//
		// DataLoader dl = new DataLoader();
		// dl.valueMap.put("账号", "123");
		// dl.valueMap.put("时间", new Date());
		// dl.valueMap.put("array", ar);
		// String s = "{账号}{时间}";
		//
		// System.out.println(dl.parseValue(String.class, s));


	}

	public void put(String name, Object value) {
		try {
			Matcher ma = BlockConstant.PATTERN_NAME_ARRAY.matcher(name);
			while (ma.find()) {
				String group = ma.group();
				Matcher ma2 = BlockConstant.PATTERN_NAME_ARRAY_POSITION.matcher(group);
				ma2.find();
				String preName = name.substring(0, ma.start() + ma2.start());
				if ("true".equals(String.valueOf(engine.eval("typeof " + preName + "=='undefined'")))) {
					engine.eval(preName + " = []");
				}
			}

			String[] splitByDot = name.split("\\.");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < splitByDot.length - 1; i++) {
				String dot = splitByDot[i];
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

					engine.eval(name + "=" + valString + "");
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

			keys.add(name);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			System.out.println(" put exception ");
			System.out.println(name);
			System.out.println(value);
			e.printStackTrace();
		}
	}

	public void putAll(Map<String, Object> object) {
		// TODO Auto-generated method stub
		if (object != null && object.size() > 0)
			for (Entry<String, Object> o : object.entrySet()) {
				put(o.getKey(), o.getValue());
			}
	}

	public Object get(String name) {
		try {
			String type = (String) engine.eval("typeof(" + name + ")");
			if (type.equals("object")) {
				return engine.eval("JSON.stringify(" + name + ")");
			} else if (type.equals("undefined")) {
				return "";
			} else {
				return engine.eval(name);
			}
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public void outputAll() {
		for (String s : keys) {
			try {
				System.out.println("name = " + s + " value =" + engine.eval(s));
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
		if (m.find()) { // 是否有匹配到内容
			m.reset();
		} else {
			return pa;
		}

		Integer st = 0, ed = 0;
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
		if (m.find()) { // 是否有匹配到内容
			m.reset();
		} else {
			return pa;
		}

		Integer st = 0, ed = 0;
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
			return tranformedValue(String.class, key);
		}

		// if (key.indexOf(".") == -1) {
		String sa = key.substring(1, key.length() - 1);
		return get(sa);
		// } else if (BlockConstant.ARRAY_LENGTH.equals(key.substring(1,
		// key.length() - 1).split("\\.")[1])) {
		// String name = key.substring(1, key.length() - 1).split("\\.")[0];
		// List list = (List) get(name);
		// if (list == null) {
		// System.out.println(name);
		// }
		// return list.size();
		//
		// } else {
		// String[] sa = key.substring(1, key.length() - 1).split( // 分成名称部分与值部分
		// "\\.");
		// Map<String, Object> ob = valueMap;
		// List ar = null;
		// for (Integer i = 0; i < sa.length; i++) {
		//
		// if (i == sa.length - 1) {
		// Matcher mm = indexPattern.matcher(sa[i]);
		// if (mm.find()) {
		// String arName = sa[i].substring(0, mm.start());
		// String indexString = mm.group();
		// indexString = indexString.substring(1, indexString.length() - 1);
		// Integer index = Integer.parseInt(indexString);
		// ar = (List) ob.get(arName);
		// if (ar == null) {
		// System.out.println(sa[i]);
		// }
		//
		// if (index >= ar.size()) {
		// return null;
		// } else if (ar.get(index) == null) {
		// return null;
		// } else {
		// return ar.get(index);
		// }
		//
		// } else {
		// return ob.get(sa[i]);
		// }
		// } else {
		// Matcher mm = indexPattern.matcher(sa[i]);
		// if (mm.find()) {
		// String arName = sa[i].substring(0, mm.start());
		// String indexString = mm.group();
		// indexString = indexString.substring(1, indexString.length() - 1);
		// Integer index = Integer.parseInt(indexString);
		// ar = (List) ob.get(arName);
		// if (ar == null) {
		// System.out.println(sa[i]);
		// }
		//
		// if (index >= ar.size()) {
		// } else if (ar.get(index) == null) {
		//
		// } else {
		// ob = (Map<String, Object>) ar.get(index);
		// }
		// } else {
		// ob = (Map<String, Object>) ob.get(sa[i]);
		// }
		// }
		// }
		// }

		// return null;

	}

	public String parseNormalValue(String pa) {

		StringBuilder sb = new StringBuilder();

		Matcher m = textPattern2.matcher(pa);
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
		pa = parseNormalValue(pa);
		String s = null;

		if (isNeedJs(pa)) {
			s = parseValueByJS(pa);
		} else {
			s = pa;
		}
		// pa = parseFourOperation(type, pa);
		while (s != null && s.startsWith("\"") && s.endsWith("\""))
			s = s.substring(1, s.length() - 1);

		return s;
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

	private String parseValueByJS(String pa) {

		String s = "";
		// TODO Auto-generated catch block
		try {

			String valueType = (String) engine.eval("typeof(" + pa + ")");
			if (valueType.equals("object")) {
				s = String.valueOf(engine.eval("JSON.stringify(" + pa + ")"));
			} else if (valueType.equals("undefined")) {
				return null;
			} else {
				s = String.valueOf(engine.eval(pa));
			}
			return s;
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			pa = "'" + pa + "'";
			try {
				String valueType = (String) engine.eval("typeof(" + pa + ")");
				if (valueType.equals("object")) {
					s = String.valueOf(engine.eval("JSON.stringify(" + pa + ")"));
				} else if (valueType.equals("undefined")) {
					return null;
				} else {
					s = String.valueOf(engine.eval(pa));
				}
			} catch (Exception se) {
				se.printStackTrace();
				return pa;
			}
			return s;
		}

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

		return "";

	}

	@Override
	public void destory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void acquireLock() {

	}

	@Override
	public void releaseLock() {

	}

	@Override
	public void release() {
		destory();
	}
}
