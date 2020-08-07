package com.lin.util;

import com.alibaba.fastjson.JSON;
import com.lin.constants.BlockConstant;
import org.apache.commons.lang3.math.NumberUtils;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;
import org.graalvm.polyglot.proxy.ProxyObject;
import stormpot.Slot;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;

public class GraalJsDataLoader implements DataloaderInterface {
    final int DefaultStartAscii = 97;
    final Slot slot;

    Context context;
    Map<String, Value> evalMap;
    Map<String, List<String>> evalParamMap;
    Set<String> keys = new LinkedHashSet<String>();

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

    public String parseStringValue(String pa) {
        if (!isNeedJs(pa)) {
            return pa;
        }
        List<String> paramList = new ArrayList();
        String s = parseBracket(pa, paramList, DefaultStartAscii);
        Value[] params = new Value[paramList.size()];

        for (int i = 0; i < paramList.size(); i++) {
            params[i] = context.getBindings("js").getMember(paramList.get(i));
            s = s.replace(String.valueOf((char) (DefaultStartAscii + i)), params[i].toString());
        }
        return s;
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

    public Object transferValue(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Map) {
            Map map = (Map) value;
            return new MapProxyObject(map);
        } else if (value instanceof List) {
            List list = (List) value;
            if (list.get(0) instanceof Map) {
                ProxyObject[] objects = new ProxyObject[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    objects[i] = new MapProxyObject((Map) list.get(i));
                }
                return objects;
            } else {
                return Value.asValue(value);
            }
        } else if (value.getClass().isArray()) {
            if (Map.class.isAssignableFrom(value.getClass().getComponentType())) {
                ProxyObject[] objects = new ProxyObject[Array.getLength(value)];
                for (int i = 0; i < Array.getLength(value); i++) {
                    objects[i] = new MapProxyObject((Map) Array.get(value, i));
                }
                return objects;
            } else {
                return Value.asValue(value);
            }
        } else {
            try {
                if (NumberUtils.isParsable(String.valueOf(value))) {
                    return Value.asValue(Double.parseDouble(value.toString()));
                } else {
                    return Value.asValue(value);
                }
            } catch (Exception e) {
                return Value.asValue(value);
            }
        }
    }

    public void put(String name, Object value) {
        keys.add(name);
        putStr(name, value);
    }

    public void putStr(String name, Object value) {
        name = parseValue(name).toString();
        Value object = context.getBindings("js");
        StringBuilder sb = new StringBuilder();

        String[] splitByDot = name.split("\\.");
        List<String> list = new ArrayList();
        for (int i = 0; i < splitByDot.length; i++) {
            String dot = splitByDot[i];
            Matcher m = BlockConstant.PATTERN_NAME_ARRAY_MAP_POSITION.matcher(dot);

            int end = 0;
            while (m.find()) {
                String preStr = dot.substring(end, m.start());
                if (preStr.length() > 0) {
                    list.add(preStr);
                }
                end = m.end();
                String matchedStr = m.group();
                list.add(matchedStr.substring(1, matchedStr.length() - 1));
            }
            if (end < dot.length()) {
                list.add(dot.substring(end));
            }
        }
        for (int i = 0; i < list.size() - 1; i++) {
            String preStr = list.get(i);
            if (!object.hasMember(preStr)) {
                Value v = Value.asValue(new MapProxyObject());
                object.putMember(preStr, v);
            }
            object = object.getMember(preStr);
        }

        object.putMember(list.get(list.size() - 1), transferValue(value));
    }

    public void putAll(Map<String, Object> object) {
        if (object == null) {
            return;
        }
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

    @Override
    public Set<String> getKeys() {
        return keys;
    }

    public static class MapProxyObject implements ProxyObject {
        private final Map<String, Object> values;

        public MapProxyObject() {
            this.values = new HashMap();
        }

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
