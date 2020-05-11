package com.lin.util;

import com.alibaba.fastjson.JSON;
import com.lin.constants.BlockConstant;
import org.apache.commons.lang3.StringUtils;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;
import org.graalvm.polyglot.proxy.ProxyObject;
import stormpot.Slot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

public class GraalJsDataLoader implements DataloaderInterface {
    final int DefaultStartAscii = 97;
    final Slot slot;

    Context context;
    Map<String, Value> evalMap;
    Map<String, List<String>> evalParamMap;

    public GraalJsDataLoader(Slot slot) {
        this.slot = slot;
        context = Context.newBuilder("js")
                .allowAllAccess(true)
                .build();
        evalMap = new HashMap<>();
        evalParamMap = new HashMap<>();
    }

    public static class A {
        public String name;
        public Double price;

        A(String name, Double price) {
            A.this.name = name;
            A.this.price = price;
        }
    }

    public static class C {
        public String name;
        public int count;

        C(String name, int count) {
            C.this.name = name;
            C.this.count = count;
        }
    }

    public static void main(String[] args) {
        GraalJsDataLoader g = new GraalJsDataLoader(null);
        g.context.eval("js", "a={},a.a= 1;");
        Value v = g.context.getBindings("js");

        System.out.println(g.context.eval("js", "a.a").toString());

        Map map = new HashMap();
        map.put("price", 5);
        map.put("name", "a2");

        g.put("testmap", map);
        map.put("count", 3);
        g.put("testmap.count", 5);


        g.put("货物表", JSON.parse("[\n" +
                "        {\n" +
                "            \"商品id\": 9,\n" +
                "            \"商品数量\": 10\n" +
                "        },\n" +
                "        {\n" +
                "            \"商品id\": 10,\n" +
                "            \"商品数量\": 2\n" +
                "        }\n" +
                "    ]"));
        g.put("序号", "1");
        g.put("价格", 10);
        System.out.println(g.parseValue("{货物表}[{序号}].商品id"));
//
//        Long size = 1000000L;
//        for (Long i = 0L; i < size; i++) {
//            Long time = System.nanoTime();
//            Value newValue = g.parseValue("{商品信息}[{序号}].price*{货物表}[{序号}].count+{价格}");
//            Long time1 = System.nanoTime() - time;
//            time = System.nanoTime();
//            g.put("价格", newValue);
//            Long time2 = System.nanoTime() - time;
//            if (i > (size - 100)) {
//                System.out.println(i + "======" + newValue + "=== time= " +  time1 +" ===== "+time2);
//            }
//        }
    }


    public boolean isNeedJs(String pa) {
        Matcher m = textPattern2.matcher(pa);
        if (m.find()) {
            return true;
        }

        if (pa.startsWith("[")
                || pa.startsWith("{")) {
            return true;
        }
        return false;
    }

    public Object parseJsonValue(String pa) {
        Value v = parseValue(pa);
        if (v.isNull()) {
            return null;
        }
        if (v.isHostObject()) {
            Object value = v.asHostObject();
            if (value instanceof List) {
                List list = (List) value;
                if (list.get(0) instanceof ProxyObject) {
                    Map[] objects = new Map[list.size()];
                    for (int i = 0; i < list.size(); i++) {
                        MapProxyObject proxy = (MapProxyObject) list.get(i);
                        objects[i] = proxy.values;
                    }
                    return objects;
                } else {
                    Object[] objects = new Object[list.size()];
                    for (int i = 0; i < list.size(); i++) {
                        objects[i] = list.get(i);
                    }
                    return objects;
                }
            } else if (value.getClass().isArray()) {
                if (ProxyObject.class.isAssignableFrom(value.getClass().getComponentType())) {
                    Map[] objects = new Map[Array.getLength(value)];
                    for (int i = 0; i < Array.getLength(value); i++) {
                        MapProxyObject proxy = (MapProxyObject) Array.get(value, i);
                        objects[i] = proxy.values;
                    }
                    return objects;
                } else {
                    Object[] objects = new Object[Array.getLength(value)];
                    for (int i = 0; i < Array.getLength(value); i++) {
                        objects[i] = Array.get(value, i);
                    }
                    return objects;
                }
            } else {
                return value;
            }
        } else if (v.isProxyObject()) {
            MapProxyObject map = v.asProxyObject();
            return map.values;
        } else {
            return v.toString();
        }
    }

    public Value parseValue(String pa) {
        Value v = null;
        if (!isNeedJs(pa)) {
            return Value.asValue(pa);
        }

        if (evalMap.containsKey(pa)) {
            v = evalMap.get(pa);
        } else {
            List<String> paramList = new ArrayList();
            String s = parseBracket(pa, paramList, DefaultStartAscii);
            StringBuilder sb = new StringBuilder();
            sb.append("(function(");
            for (int i = 0; i < paramList.size(); i++) {
                sb.append((char) (DefaultStartAscii + i));
                if (i != paramList.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append("){return ");
            sb.append(s);
            sb.append("; })");
            v = context.eval("js", sb.toString());
            evalMap.put(pa, v);
            evalParamMap.put(pa, paramList);
        }


        List<String> paramList = evalParamMap.get(pa);
        Value[] params = new Value[paramList.size()];

        for (int i = 0; i < paramList.size(); i++) {
            params[i] = context.getBindings("js").getMember(paramList.get(i));
        }

        return v.execute(params);
    }

    //转换括号包含的数据  //耗时很长
    public String parseBracket(String pa, List<String> paramList, int startAscii) {
        StringBuilder sb = new StringBuilder();

        Matcher m = textPattern2.matcher(pa);
        Integer st = 0, ed = 0;

        if (m.find()) { // 是否有匹配到内容
            m.reset();
        } else {
            return pa;
        }

        int ascii = startAscii;
        while (m.find()) {
            String temp = pa.substring(ed, m.start());
            sb.append(temp);
            ed = m.end();
            st = m.start();

            String groupStr = m.group();

            sb.append((char) ascii++);
            paramList.add(groupStr.substring(1, groupStr.length() - 1));
        }

        if (ed != 0 && ed != pa.length()) {
            sb.append(pa.substring(ed, pa.length()));
        }
        String value = sb.toString();
        return parseBracket(value, paramList, ascii);
    }

//    public void put(String name, Object value) {
//        name=parseValue(name).toString();
//
//        if (value instanceof Map) {
//            Map map = (Map) value;
//            context.getBindings("js").putMember(name, new MapProxyObject(map));
//        } else if (value instanceof List) {
//            List list = (List) value;
//            if (list.get(0) instanceof Map) {
//                ProxyObject[] objects = new ProxyObject[list.size()];
//                for (int i = 0; i < list.size(); i++) {
//                    objects[i] = new MapProxyObject((Map) list.get(i));
//                }
//                context.getBindings("js").putMember(name, objects);
//            } else {
//                context.getBindings("js").putMember(name, Value.asValue(value));
//            }
//        } else if (value.getClass().isArray()) {
//            if (Map.class.isAssignableFrom(value.getClass().getComponentType())) {
//                ProxyObject[] objects = new ProxyObject[Array.getLength(value)];
//                for (int i = 0; i < Array.getLength(value); i++) {
//                    objects[i] = new MapProxyObject((Map) Array.get(value, i));
//                }
//                context.getBindings("js").putMember(name, objects);
//            } else {
//                context.getBindings("js").putMember(name, Value.asValue(value));
//            }
//        } else {
//            try {
//                if (NumberUtils.isParsable(String.valueOf(value))) {
//                    context.getBindings("js").putMember(name, Value.asValue(Double.parseDouble(value.toString())));
//                }else{
//                    context.getBindings("js").putMember(name, Value.asValue(value));
//                }
//            } catch (Exception e) {
//                context.getBindings("js").putMember(name, Value.asValue(value));
//            }
//        }
//    }

    public void put(String name, Object value) {
        context.eval("js", putStr(name, value));
//        keys.add(name);
    }

    public String putStr(String name, Object value) {
        StringBuilder scriptStr = new StringBuilder();

        Matcher ma = BlockConstant.PATTERN_NAME_ARRAY.matcher(name);
        while (ma.find()) {
            String group = ma.group();
            Matcher ma2 = BlockConstant.PATTERN_NAME_ARRAY_POSITION.matcher(group);
            ma2.find();
            String preName = name.substring(0, ma.start() + ma2.start());
            if ("true".equals(String.valueOf(context.eval("js", "typeof " + preName + "=='undefined'")))) {
                scriptStr.append(preName + " = [];");
            }
        }

        String[] splitByDot = name.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splitByDot.length - 1; i++) {
            String dot = splitByDot[i];
            sb.append(dot);
            if ("true".equals(String.valueOf(context.eval("js", "typeof " + sb.toString() + "=='undefined'")))) {
                scriptStr.append(sb.toString() + " = {};");
            }
            sb.append(".");
        }

        if (value instanceof String) {
            String valString = (String) value;
            valString = valString.replace("\n", "");

            if (valString.startsWith("[") || valString.startsWith("{") || valString.startsWith("\"")|| StringUtils.isNumeric(valString)) {
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
        for (Map.Entry<String, Object> e : object.entrySet()) {
            put(e.getKey(), e.getValue());
        }
    }

    public Object get(String name) {
        if (context.getBindings("js").hasMember(name))
            return context.getBindings("js").getMember(name);
        else {
            return "";
        }
    }

    public void release() {
        for (String key : context.getBindings("js").getMemberKeys()) {
            context.getBindings("js").removeMember(key);
        }
        slot.release(this);
    }

    public void destory() {
        context.close();
    }

    @Override
    public void acquireLock() {

    }

    @Override
    public void releaseLock() {

    }

    public static class MapProxyObject implements ProxyObject {
        private final Map<String, Object> values;

        public MapProxyObject(Map<String, Object> values) {
            if (values == null) {
                this.values = new HashMap();
            } else {
                this.values = values;
            }
        }

        public void putMember(String key, Value value) {
            values.put(key, value.isHostObject() ? value.asHostObject() : value);
        }

        public boolean hasMember(String key) {
            return values.containsKey(key);
        }

        public Object getMemberKeys() {
            return values.keySet().toArray();
        }

        public Object getMember(String key) {
            Object v = values.get(key);
            if (v instanceof Map) {
                return new MapProxyObject((Map<String, Object>) v);
            } else {
                return v;
            }
        }

        public Map<String, Object> getMap() {
            return values;
        }
    }
}
