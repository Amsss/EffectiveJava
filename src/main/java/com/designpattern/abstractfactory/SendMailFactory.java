package com.designpattern.abstractfactory;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:06
 */
public class SendMailFactory implements Provider {

    @Override
    public Sender produce() {
        return new MailSender();
    }
}
