package com.map;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-26 15:44
 */
public class Demo {
    public static void main(String[] args) {
        Map<String,Object> a = new HashMap<>(16);
        a.put("1","111");
        a.put("2","222");
        Set<String> XX1 = new HashSet<>(16);
        Set<String> XX = a.keySet();
        a.put("3","333");
        a.put("4","444");
        a.put("5","555");
        a.put("6","666");
        System.out.println(XX);
        XX.remove("6");
        System.out.println(a);

        //System.out.println(comparableClassFor(new A()));    // null,A does not implement Comparable.
        //System.out.println(comparableClassFor(new B()));    // null,B implements Comparable, compare to Object.
        //System.out.println(comparableClassFor(new C()));    // class Demo$C,C implements Comparable, compare to itself.
        //System.out.println(comparableClassFor(new D()));    // null,D implements Comparable, compare to its sub type.
        //System.out.println(comparableClassFor(new F()));    // null,F is C's sub type.
    }

    static class A {
    }

    static class B implements Comparable<Object> {
        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }

    static class C implements Comparable<C> {
        @Override
        public int compareTo(C o) {
            return 0;
        }

    }

    static class D implements Comparable<E> {
        @Override
        public int compareTo(E o) {
            return 0;
        }
    }

    static class E {
    }

    static class F extends C {
    }

    /**
     * Returns x's Class if it is of the form "class C implements
     * Comparable<C>", else null.
     */
    static Class<?> comparableClassFor(Object x) {
        if (x instanceof Comparable) {
            Class<?> c;
            Type[] ts, as;
            Type t;
            ParameterizedType p;
            if ((c = x.getClass()) == String.class) // bypass checks
            {
                return c;
            }
            if ((ts = c.getGenericInterfaces()) != null) {
                for (int i = 0; i < ts.length; ++i) {
                    if (((t = ts[i]) instanceof ParameterizedType) &&
                            ((p = (ParameterizedType) t).getRawType() ==
                                    Comparable.class) &&
                            (as = p.getActualTypeArguments()) != null &&
                            as.length == 1 && as[0] == c) // type arg is c
                    {
                        return c;
                    }
                }
            }
        }
        return null;
    }
}
