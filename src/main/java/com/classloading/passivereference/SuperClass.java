package com.classloading.passivereference;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018-06-12 15:28
 */
public class SuperClass extends SuperSuperClass{
    static {
        System.out.println("SuperClass static init!");
    }
    public static int superValue = 123;

    public static  final  String HELLO = "HELLO";
}
