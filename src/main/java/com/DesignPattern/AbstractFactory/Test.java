package com.DesignPattern.AbstractFactory;

public class Test {

    public static void main(String[] args) {
        Provider mailProvider = new SendMailFactory();
        Sender mailsender = mailProvider.produce();
        mailsender.Send();
        Provider smsProvider = new SendSmsFactory();
        Sender smssender = smsProvider.produce();
        smssender.Send();
    }
}
