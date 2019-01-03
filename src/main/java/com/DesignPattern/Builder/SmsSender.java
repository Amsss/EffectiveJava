package com.DesignPattern.Builder;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/3 16:13
 */
public class SmsSender implements Sender {

    @Override
    public void send() {
        System.out.println("this is sms sender!");
    }

}
