package com.collection.array;

/**
 * @description: 由基本数据类型构成的数组会自动初始化成零（针对数值类型）、null（字符类型）或者false（布尔类型）
 * @author: zhuzz
 * @date: 2019-04-25 14:13
 */
public class ArraySize {
    public static void main(String[] args) {
        // Arrays of objects:
        Weeble[] a;
        // Null handles
        Weeble[] b = new Weeble[5];
        // Null handle
        Weeble[] c = new Weeble[4];
        for (int i = 0; i < c.length; i++) {
            c[i] = new Weeble();
        }
        Weeble[] d = {
                new Weeble(), new Weeble(), new Weeble()
        };
        // Compile error: variable a not initialized:
        //!System.out.println("a.length=" + a.length);
        System.out.println("b.length = " + b.length);
        // The handles inside the array are
        // automatically initialized to null:
        for (int i = 0; i < b.length; i++) {
            System.out.println("b[" + i + "]=" + b[i]);
        }
        System.out.println("c.length = " + c.length);
        System.out.println("d.length = " + d.length);
        a = d;
        System.out.println("a.length = " + a.length);
        // Java 1.1 initialization syntax:
        a = new Weeble[]{
                new Weeble(), new Weeble()
        };
        System.out.println("a.length = " + a.length);
        // Arrays of primitives:
        int[] e; // Null handle
        int[] f = new int[5];
        int[] g = new int[4];
        for (int i = 0; i < g.length; i++) {
            g[i] = i * i;
        }
        int[] h = {11, 47, 93};
        // Compile error: variable e not initialized:
        //!System.out.println("e.length=" + e.length);
        System.out.println("f.length = " + f.length);
        // The primitives inside the array are
        // automatically initialized to zero:
        for (int i = 0; i < f.length; i++) {
            System.out.println("f[" + i + "]=" + f[i]);
        }
        System.out.println("g.length = " + g.length);
        System.out.println("h.length = " + h.length);
        e = h;
        System.out.println("e.length = " + e.length);
        // Java 1.1 initialization syntax:
        e = new int[]{1, 2};
        System.out.println("e.length = " + e.length);
    }
}
