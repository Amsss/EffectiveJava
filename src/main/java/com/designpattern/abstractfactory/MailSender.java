package com.designpattern.abstractfactory;

/**
 * @description: 邮件发送类
 * @author: zhuzz
 * @date: 2019/1/7 10:59
 */
public class MailSender implements Sender {

    @Override
    public void send() {
        System.out.println("this is mailSender!");
    }
}
