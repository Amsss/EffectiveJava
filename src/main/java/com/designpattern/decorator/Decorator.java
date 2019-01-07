package com.designpattern.decorator;

/**
 * @description: 装饰器模式
 * @author: zhuzz
 * @date: 2019/1/3 16:11
 */
public class Decorator implements Sourceable {

    private Sourceable source;

    public Decorator(Sourceable source) {
        super();
        this.source = source;
    }

    @Override
    public void method() {
        System.out.println("before decorator!");
        source.method();
        System.out.println("after decorator!");
    }
}
