package com.classLoading.passiveReference;

/**
 * @Description:
 * @author: zhuzz
 * @date: 2018-06-12 15:29
 */
public class SubClass extends SuperClass{
    static {
        System.out.println("SubClass static init!");
    }
}
