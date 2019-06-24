package com.designpattern.builder;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/3 16:13
 */
public class Test {
    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.produceMailSender(10);
    }
}
