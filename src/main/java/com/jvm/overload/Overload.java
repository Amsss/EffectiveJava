package com.jvm.overload;

import java.io.Serializable;

/**
 * @Description: 重载方法匹配优先级
 * @author: zhuzz
 * @date: 2018-06-19 10:15
 */
public class Overload {
    public static void sayHello(Object arg) {
        System.out.println("hello Object");
    }

    public static void sayHello(int arg) {
        System.out.println("hello int");
    }

    public static void sayHello(long arg) {
        System.out.println("hello long");
    }

    public static void sayHello(Character arg) {
        System.out.println("hello Character");
    }

    public static void sayHello(char arg) {
        System.out.println("hello char");
    }

    /**
     * 变长参数的重载优先级是最低的
     * @param arg
     */
    public static void sayHello(char... arg) {
        System.out.println("hello char...");
    }

    public static void sayHello(Serializable arg) {
        System.out.println("hello Serializable");
    }

    /**
     * char -> int -> long -> float -> double
     * (但不会匹配到byte和short类型的重载 因为char到byte或short的转型是不安全的）
     * @param args
     */
    public static void main(String[] args) {
        sayHello('a');
    }
}
