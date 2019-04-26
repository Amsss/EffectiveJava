package com.classloading.passivereference;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018-06-12 15:29
 */
class SubClass extends SuperClass {
    static {
        System.out.println("SubClass static init!");
    }
}
