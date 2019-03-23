package com.lin.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lin.dao.DataTableDao;
import com.lin.entity.NextRequirementEntity;
import com.lin.interfacePackage.Annotation.DatabaseTableAnnotation;
import com.lin.interfacePackage.Annotation.PlguinMethodOutputParamAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodAnnotation;
import com.lin.interfacePackage.Annotation.PluginMethodParamAnnotation;

public class ParamUtil {

	public static void main(String[] args) {
		System.out.println(compare("", "<>", ""));
		System.out.println(compare("", "=", ""));
	}

	public static JSONObject getParams(Class clz, String methodName, DataTableDao tableDao)
			throws IllegalArgumentException, NoSuchMethodException, SecurityException {
		Method[] methods = clz.getDeclaredMethods();
		for (Method method : methods) {
			if (!method.getName().equals(methodName) || method.getAnnotation(PluginMethodAnnotation.class) == null)
				continue;

			Parameter[] parameters = method.getParameters();
			JSONObject paramObject = new JSONObject();
			{
				JSONArray array = new JSONArray();
				Class paClz = parameters[0].getType();
				Field[] fields = paClz.getDeclaredFields();

				for (Field f : fields) {
					if (f.getAnnotation(PluginMethodParamAnnotation.class) != null) {
						PluginMethodParamAnnotation anno = f.getAnnotation(PluginMethodParamAnnotation.class);
						if (anno != null) {
							JSONObject ob = new JSONObject();
							ob.put("name", anno.displayName());
							ob.put("displayName", anno.displayName());
							ob.put("isNecessary", anno.isNecessary());
							ob.put("pattern", anno.pattern());
							ob.put("optional", anno.optional());
							ob.put("size", anno.size());
							ob.put("fieldName", f.getName());
							array.add(ob);
						}
					} else if (f.getAnnotation(DatabaseTableAnnotation.class) != null) {
						DatabaseTableAnnotation tableAnno = f.getAnnotation(DatabaseTableAnnotation.class);
						if (tableAnno != null) {
							JSONObject ob = new JSONObject();
							ob.put("name", tableAnno.displayName());
							ob.put("displayName", tableAnno.displayName());
							ob.put("optional", tableDao.getAvailableDataTable());
							ob.put("fieldName", f.getName());
							array.add(ob);
							continue;
						}
					}
				}
				paramObject.put("input", array);
			}
			{
				JSONArray array = new JSONArray();
				Class paClz = parameters[1].getType();
				Field[] fields = paClz.getDeclaredFields();

				for (Field f : fields) {
					if (f.getAnnotation(PlguinMethodOutputParamAnnotation.class) != null) {
						PlguinMethodOutputParamAnnotation anno = f
								.getAnnotation(PlguinMethodOutputParamAnnotation.class);

						if (anno != null) {
							JSONObject ob = new JSONObject();
							ob.put("name", anno.displayName());
							ob.put("displayName", anno.displayName());
							ob.put("fieldName", f.getName());
							array.add(ob);
						}
					}
				}
				paramObject.put("output", array);
			}

			return paramObject;
		}
		return null;

	}

	public static Object transfer(Class origin, Class dest, Object value) {

		return null;
	}

	public static boolean compare(String param1, String method, String param2) {

		System.out.println("param1=(" + param1 + ") method=" + method + " param2=(" + param2 + ")");

		if (StringUtils.isBlank(param1) && StringUtils.isBlank(param2) && method.equals("=")) {
			return true;
		}

		Pattern pattern = null;

		if (method.equals("=")) {
			try {
				return Double.parseDouble(param1) == Double.parseDouble(param2) ? true : false;
			} catch (NumberFormatException e) {

			}

			if (param1 == param2)
				return true;

			if (param1 != null) {
				return param1.equals(param2);
			} else {
				return param2.equals(param1);
			}
		} else if (method.equals("<")) {
			return Double.parseDouble(param1) < Double.parseDouble(param2) ? true : false;
		} else if (method.equals(">")) {
			return Double.parseDouble(param1) > Double.parseDouble(param2) ? true : false;
		} else if (method.equals("<=")) {
			return Double.parseDouble(param1) <= Double.parseDouble(param2) ? true : false;
		} else if (method.equals(">=")) {
			return Double.parseDouble(param1) >= Double.parseDouble(param2) ? true : false;
		} else if (method.equals("<>")) {
			return !compare(param1, "=", param2);
		} else if (method.equals("like")) {
			return param1.indexOf(param2) >= 0 ? true : false;
		} else if (method.equals("not like")) {
			return param1.indexOf(param2) < 0 ? true : false;
		} else if (method.equals("regular")) { // 正则表达式
			if (pattern == null)
				pattern = Pattern.compile(param2);
			Matcher m = pattern.matcher(param1);
			return m.find();
		} else if (method.equals("not regular")) { // 正则表达式
			if (pattern == null)
				pattern = Pattern.compile(param2);
			Matcher m = pattern.matcher(param1);
			return !m.find();
		} else
			return false;
	}

	public static boolean isOK(DataLoader loader, NextRequirementEntity requirement) {
		String parsedContent = (String) loader.parseValue(requirement.getParam1());
		String parsedContent2 = (String) loader.parseValue(requirement.getParam2());
		String method = requirement.getMethod();

		if (parsedContent == null || parsedContent2 == null)
			return false;

		return compare(parsedContent, method, parsedContent2);
	}

	public static String getNegativeMethod(String method) {
		switch (method) {
		case "=":
			return "<>";
		case "<":
			return ">=";
		case ">":
			return "<=";
		case "<=":
			return ">";
		case ">=":
			return "<";
		case "<>":
			return "=";
		case "like":
			return "not like";
		case "not like":
			return "like";
		case "not regular":
			return "regular";
		case "regular":
			return "not regular";
		}
		return null;
	}

	public static boolean isArgument(String param) {
		if (param.startsWith("{") && param.endsWith("}")) {
			return true;
		}
		return false;

	}

	public static boolean isConflict(String value, String method, String param2) {
		// TODO Auto-generated method stub
		return compare(value, getNegativeMethod(method), param2);
	}

}