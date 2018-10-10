package com.DesignPattern.ChainofResponsibility;

/**
 * @description: 责任链模式
 * @author: zhuzz
 * @date: 2018/10/9 13:57
 */
public class Test {
    public static void main(String[] args) {
        MyHandler h1 = new MyHandler("h1");
        MyHandler h2 = new MyHandler("h2");
        MyHandler h3 = new MyHandler("h3");

        h2.setHandler(h3);
        h1.setHandler(h2);

        h1.operator();
    }
}
