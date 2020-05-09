package com.lin;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class Test {

    public static void main(String[] args) {
        Context p = Context.newBuilder("js")
                .allowAllAccess(true)
                .build();
        Value v = p.eval("js", "(function(a,b,c,d) {return a[b].price*c[b].count+d })");
        Long time = System.nanoTime();
        Long size = 1000000L;
        for (Long i = 0L; i < size; i++) {
            time = System.nanoTime();
            v.putMember("货物表",new A[]{new A("A1",10D),new A("A2",5D)});
            v.putMember("商品信息",new C[]{new C("C1",5),new C("C2",2)});
            v.putMember("序号",1);
            v.putMember("价格",10);
            String str = v.execute(v.getMember("货物表"),v.getMember("序号"),v.getMember("商品信息"),v.getMember("价格")).toString();

            if (i > (size - 100)) {
                System.out.println(i + "======" + str + "=== time= " + (System.nanoTime() - time));
            }
        }
    }

    public static class A  {
        public String name;
        public Double price;

        A(String name, Double price) {
            A.this.name = name;
            A.this.price = price;
        }
    }

    public static class C  {
        public String name;
        public int count;

        C(String name, int count) {
            C.this.name = name;
            C.this.count = count;
        }
    }
}
