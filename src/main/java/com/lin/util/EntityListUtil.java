package com.lin.util;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class EntityListUtil {
	public static Object findFromList(List list, String field, String value) {
		JSONArray ar = new JSONArray(list);
		for (int i = 0; i < ar.size(); i++) {
			JSONObject o = ar.getJSONObject(i);
			if (o.containsKey(field) && o.getString(field) != null && o.getString(field).equals(value)) {
				return list.get(i);
			}
		}
		return null;
	}

	public static Object findFromList(List list, String field, Integer value) {
		JSONArray ar = new JSONArray(list);
		for (int i = 0; i < ar.size(); i++) {
			JSONObject o = ar.getJSONObject(i);
			if (o.containsKey(field) && o.getInteger(field) != null && o.getInteger(field).equals(value)) {
				return list.get(i);
			}
		}
		return null;
	}

	public static List findListFromList(List list, String field, String value) {
		JSONArray ar = new JSONArray(list);
		List<Object> ob = new ArrayList();

		for (int i = 0; i < ar.size(); i++) {
			JSONObject o = ar.getJSONObject(i);
			if (o.containsKey(field) && o.getString(field) != null && o.getString(field).equals(value)) {
				ob.add(list.get(i));
			}
		}
		return ob;
	}

	public static List findListFromList(List list, String field, Integer value) {
		JSONArray ar = new JSONArray(list);
		List<Object> ob = new ArrayList();
		for (int i = 0; i < ar.size(); i++) {
			JSONObject o = ar.getJSONObject(i);
			if (o.containsKey(field) && o.getInteger(field) != null && o.getInteger(field).equals(value)) {
				ob.add(list.get(i));
			}
		}
		return ob;
	}
}
