package com.designpattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/3 16:12
 */
public class Builder {

    private List<Sender> list = new ArrayList<>(16);

    public void produceMailSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new SmsSender());
        }
    }
}
