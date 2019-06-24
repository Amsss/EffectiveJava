package com.designpattern.builder;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/3 16:15
 */
public class MailSender implements Sender {

    @Override
    public void send() {
        System.out.println("this is mailsender!");
    }
}
