package com.lin.util;

import com.alibaba.fastjson.JSON;
import com.lin.constants.BlockConstant;
import com.lin.entity.AbstractEntity;
import com.lin.nettyserver.http.util.string.StringConverter;
import com.lin.nettyserver.http.util.string.StringConverters;
import org.apache.commons.lang3.StringUtils;
import org.graalvm.polyglot.Context;
import stormpot.Slot;

import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnotherJsDataLoader implements DataloaderInterface {
    // public ConcurrentHashMap<String, Object> valueMap = new
    // ConcurrentHashMap<String, Object>();
    private final Slot slot;

    Context context;


    private List<String> keys = new ArrayList<String>();


    public static Pattern indexPattern = Pattern.compile("\\[[0-9]+\\]"); // 位置匹配正则式

    public static Pattern sumPattern = Pattern.compile("(?i)sum\\([\\{\\}A-Z0-9a-z_]\\)+"); // 位置匹配正则式

    public static Pattern countPattern = Pattern.compile("(?i)count\\([\\{\\}A-Z0-9a-z_]\\)+"); // 位置匹配正则式
    private List<String> functionList = new ArrayList<String>();
    public AnotherJsDataLoader(Slot slot){
        this.slot=slot;
        context = Context.newBuilder("js")
                .allowAllAccess(true)
                .build();
    }
    public AnotherJsDataLoader(String filePath, Slot slot) {
        this.slot = slot;
        context = Context.newBuilder("js")
                .allowAllAccess(true)
                .build();
    }
    public static class C {
        public String name;
        public int count;

        C(String name, int count) {
            C.this.name = name;
            C.this.count = count;
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
		List ar = new ArrayList();
		ar.add("1");
		ar.add("2");

        Map map = new HashMap();
        map.put("price", 5);
        map.put("name", "a2");


		AnotherJsDataLoader dl = new AnotherJsDataLoader(null);
		dl.put("账号", "123");
		dl.put("时间", new Date().toString());
		dl.put("array", ar);
		String s = "{账号}{时间}";

        dl.put("testmap", map);
        dl.put("商品信息", new Map[]{map, map});
        dl.put("货物表", new C[]{new C("C1", 5), new C("C2", 2)});
        dl.put("序号", 0);
        dl.put("价格", 10);

        Long size = 1000000L;
        for (Long i = 0L; i < size; i++) {
            Long time = System.nanoTime();
            String newValue = dl.parseValue("{商品信息}[{序号}].price*{货物表}[{序号}].count+{价格}");
            Long time1 = System.nanoTime() - time;
            time = System.nanoTime();
            dl.put("价格", newValue);
            Long time2 = System.nanoTime() - time;
            if (i > (size - 100)) {
                System.out.println(i + "======" + newValue + "=== time= " +  time1 +" ===== "+time2);
            }
        }
    }
    public Object parseJsonValue(String pa){
        return parseValue(pa);
    }
    public String parseStringValue(String pa){
        return parseValue(pa);
    }


    public void put(String name, Object value) {
        context.eval("js",putStr(name, value));
        keys.add(name);
    }

    public String putStr(String name, Object value) {
        StringBuilder scriptStr = new StringBuilder();

        Matcher ma = BlockConstant.PATTERN_NAME_ARRAY.matcher(name);
        while (ma.find()) {
            String group = ma.group();
            Matcher ma2 = BlockConstant.PATTERN_NAME_ARRAY_POSITION.matcher(group);
            ma2.find();
            String preName = name.substring(0, ma.start() + ma2.start());
            if ("true".equals(String.valueOf(context.eval("js","typeof " + preName + "=='undefined'")))) {
                scriptStr.append(preName + " = [];");
            }
        }

        String[] splitByDot = name.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splitByDot.length - 1; i++) {
            String dot = splitByDot[i];
            sb.append(dot);
            if ("true".equals(String.valueOf(context.eval("js","typeof " + sb.toString() + "=='undefined'")))) {
                scriptStr.append(sb.toString() + " = {};");
            }
            sb.append(".");
        }

        if (value instanceof String) {
            String valString = (String) value;
            valString = valString.replace("\n", "");

            if (valString.startsWith("[") || valString.startsWith("{") || valString.startsWith("\"")) {
                scriptStr.append(name + "=" + valString + ";");
            } else {
                if (valString.indexOf("\"") != -1 && valString.indexOf("") == -1) {
                    scriptStr.append(name + "='" + valString + "';");
                } else if (valString.indexOf("'") != -1 && valString.indexOf("\"") == -1) {
                    scriptStr.append(name + "=\"" + valString + "\";");
                } else if (valString.indexOf("'") != -1 && valString.indexOf("\"") != -1) {
                    scriptStr.append(name + "=\"" + valString.replace("\"", "\\\"") + "\";");
                } else {
                    scriptStr.append(name + "='" + valString + "';");
                }
            }
        } else {
            scriptStr.append(name + "=" + JSON.toJSONStringWithDateFormat(value, "yyyy-MM-dd HH:mm:ss") + ";");
        }
        return scriptStr.toString();
    }

    public void putAll(Map<String, Object> object) {
        // TODO Auto-generated method stub

        if (object != null && object.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (Entry<String, Object> o : object.entrySet()) {
                sb.append(putStr(o.getKey(), o.getValue()));
                keys.add(o.getKey());
            }
            context.eval("js",sb.toString());
        }
    }

    public Object get(String name) {

        if (StringUtils.isBlank(name))
            return "";
        String type = context.eval("js","typeof(" + name + ")").toString();
        if (type.equals("object")) {
            return context.eval("js","JSON.stringify(" + name + ")").toString();
        } else if (type.equals("undefined")) {
            return "";
        } else {
            return context.getBindings("js").getMember(name).toString();
        }
    }

    public void outputAll() {
        for (String s : keys) {
            System.out.println("name = " + s + " value =" + context.eval("js",s));
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

    //转换括号包含的数据  //耗时很长
    public String parseBracket(String pa) {

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

            String groupStr = m.group();

//			String sa = groupStr.substring(1, groupStr.length() - 1);
//			if (engine.contains(sa)){
//				sb.append(sa);
//			}else{
            Object object = getValue(groupStr);
            if (object instanceof String) {
                sb.append(object);
            } else {
                sb.append(JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss"));
            }
//			}

        }

        if (ed != 0 && ed != pa.length()) {
            sb.append(pa.substring(ed, pa.length()));
        }
        String value = sb.toString();
        return parseBracket(value);
    }

    //主要
    public String parseValue(String pa) {
        String origin = pa;
        pa = parseBracket(pa);
        String s = null;

        if (/*engine.contains(pa)||*/ isNeedJs(pa)) {
            s = parseValueByJS(pa);
        } else {
            s = pa;
        }
        // pa = parseFourOperation(type, pa);
        while (s != null && s.startsWith("\"") && s.endsWith("\""))
            s = s.substring(1, s.length() - 1);
        return s;
    }

    public boolean isNeedJs(String pa) {
        boolean fourFundamental = false;
        if (pa.indexOf("+") > 0 || pa.indexOf("-") > 0 || pa.indexOf("*") > 0 || pa.indexOf("/") > 0) {
            fourFundamental = true;
        }

        for (String func : functionList) {
            if (pa.indexOf(func) != -1) {
                return true;
            }
        }

        if (fourFundamental || pa.startsWith("[")
                || pa.startsWith("{")) {
            return true;
        }
        return false;
    }

    private String parseValueByJS(String pa) {

        String s = "";
        // TODO Auto-generated catch block
        if (StringUtils.isBlank(pa)) {
            return "";
        }
        try {

            String valueType = context.eval("js","typeof(" + pa + ")").toString();
            if (valueType.equals("object")) {
                s = String.valueOf(context.eval("js","JSON.stringify(" + pa + ")"));
            } else if (valueType.equals("undefined")) {
                return null;
            } else {
                s = String.valueOf(context.eval("js",pa));
            }
            return s;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            pa = "'" + pa + "'";
            try {
                String valueType =context.eval("js","typeof(" + pa + ")").toString();
                if (valueType.equals("object")) {
                    s = String.valueOf(context.eval("js","JSON.stringify(" + pa + ")"));
                } else if (valueType.equals("undefined")) {
                    return null;
                } else {
                    s = String.valueOf(context.eval("js",pa));
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
        release();
        context.close();
    }

    @Override
    public void acquireLock() {

    }

    @Override
    public void releaseLock() {

    }

    @Override
    public Set<String> getKeys() {
        return null;
    }

    @Override
    public void release() {
        // TODO Auto-generated method stub
        for (String key : context.getBindings("js").getMemberKeys()) {
            context.getBindings("js").removeMember(key);
        }
        this.releaseLock();
        slot.release(this);
    }
}
