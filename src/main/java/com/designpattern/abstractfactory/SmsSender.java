package com.designpattern.abstractfactory;

/**
 * @description: Sms发送
 * @author: zhuzz
 * @date: 2019/1/7 11:02
 */
public class SmsSender implements Sender {

    @Override
    public void send() {
        System.out.println("this is smsSender!");
    }
}
