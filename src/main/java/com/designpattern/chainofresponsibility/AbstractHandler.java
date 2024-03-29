package com.designpattern.chainofresponsibility;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018/10/9 13:58
 */
public abstract class AbstractHandler {

    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
