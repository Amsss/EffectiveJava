package com.DesignPattern.Decorator;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/3 16:10
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Sourceable source = new Source();
        Sourceable obj = new Decorator(source);
        obj.method();
    }
}
