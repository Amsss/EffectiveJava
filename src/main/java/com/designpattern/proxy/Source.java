package com.designpattern.proxy;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:53
 */
public class Source implements Sourceable {

    @Override
    public void method() {
        System.out.println("the original method!");
    }
}
