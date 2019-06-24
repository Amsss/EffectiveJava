package com.designpattern.adapter.two;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:24
 */
public class Wrapper implements Targetable {

    private Source source;

    public Wrapper(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }

    @Override
    public void method1() {
        source.method1();
    }
}
