package com.classLoading.passiveReference;

/**
 * @Description:
 * @author: zhuzz
 * @date: 2018-06-12 15:28
 */
public class SuperSuperClass {
    static {
        System.out.println("SuperSuperClass static init!");
    }
    public static int superSuperValue = 123;
}
