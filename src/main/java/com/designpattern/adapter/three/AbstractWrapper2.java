package com.designpattern.adapter.three;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:19
 */
public abstract class AbstractWrapper2 implements Sourceable {
    @Override
    public void method1() {
        System.out.println("1");
    }

    @Override
    public void method2() {
        System.out.println("2");
    }
}
