package com.classloading.demo2;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 10:43
 */
public class Son extends Father {
    static {
        System.out.println("Father static block");
    }
}
