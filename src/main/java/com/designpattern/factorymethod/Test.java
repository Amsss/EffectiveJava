package com.designpattern.factorymethod;

import com.designpattern.builder.Sender;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/3 16:14
 */
public class Test {
    public static void main(String[] args) {
        Sender sender = SendFactory.produceMail();
        sender.send();
    }
}
