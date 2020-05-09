package com.lin.util;

import com.alibaba.fastjson.JSON;
import com.lin.constants.BlockConstant;
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
        g.context.eval("js","a={},a.a= 1;");
        Value v=g.context.getBindings("js");

        System.out.println(g.context.eval("js","a.a").toString());

//        Map map = new HashMap();
//        map.put("price", 5);
//        map.put("name", "a2");
//
//        g.put("testmap", map);
//        map.put("count", 3);
//        g.put("testmap.count", 5);
//        System.out.println(g.parseValue("{testmap}"));
//        System.out.println(g.parseValue("{testmap}.count"));
//        System.out.println(g.parseValue("{testmap.count}"));
//
//        g.put("商品信息", new Map[]{map, map});
//        g.put("货物表", new C[]{new C("C1", 5), new C("C2", 2)});
//        g.put("序号", 1);
//        g.put("价格", 10);
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

    public void put(String name, Object value) {
        if (value instanceof Map) {
            Map map = (Map) value;
            context.getBindings("js").putMember(name, ProxyObject.fromMap(map));
        } else if (value instanceof List) {
            List list = (List) value;
            if (list.get(0) instanceof Map) {
                ProxyObject[] objects = new ProxyObject[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    objects[i] = ProxyObject.fromMap((Map) list.get(i));
                }
                context.getBindings("js").putMember(name, objects);
            } else {
                context.getBindings("js").putMember(name, Value.asValue(value));
            }
        } else if (value.getClass().isArray()) {
            if (Map.class.isAssignableFrom(value.getClass().getComponentType())) {
                ProxyObject[] objects = new ProxyObject[Array.getLength(value)];
                for (int i = 0; i < Array.getLength(value); i++) {
                    objects[i] = ProxyObject.fromMap((Map) Array.get(value, i));
                }
                context.getBindings("js").putMember(name, objects);
            } else {
                context.getBindings("js").putMember(name, Value.asValue(value));
            }
        } else {
            context.getBindings("js").putMember(name, Value.asValue(value));
        }
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
}
