package com.designpattern.adapter.one;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:16
 */
public class AdapterTest {
    public static void main(String[] args) {
        Targetable target = new Adapter();
        target.method1();
        target.method2();
    }
}
