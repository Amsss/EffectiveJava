package com.designpattern.command;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:28
 */
public class MyCommand implements Command {

    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exe() {
        receiver.action();
    }
}
