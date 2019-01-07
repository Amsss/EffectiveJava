package com.designpattern.factorymethod;

import com.designpattern.builder.MailSender;
import com.designpattern.builder.Sender;
import com.designpattern.builder.SmsSender;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:34
 */
public class SendFactory {
    public static Sender produceMail() {
        return new MailSender();
    }

    public static Sender produceSms() {
        return new SmsSender();
    }
}
