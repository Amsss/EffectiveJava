package com.designpattern.adapter.two;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:23
 */
public class AdapterTest {
    public static void main(String[] args) {
        Source source = new Source();
        Targetable target = new Wrapper(source);
        target.method1();
        target.method2();
    }
}
