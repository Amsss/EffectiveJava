package com.designpattern.abstractfactory;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:07
 */
public class Test {

    public static void main(String[] args) {
        Provider mailProvider = new SendMailFactory();
        Sender mailSender = mailProvider.produce();
        mailSender.send();
        Provider smsProvider = new SendSmsFactory();
        Sender smsSender = smsProvider.produce();
        smsSender.send();
    }
}
