package com.classloading.demo2;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 10:43
 */
public class Father {
    public static int i = 3;

    static {
        System.out.println("Father static block");
    }
}
