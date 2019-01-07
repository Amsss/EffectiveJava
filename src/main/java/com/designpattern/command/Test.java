package com.designpattern.command;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:28
 */
public class Test {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command cmd = new MyCommand(receiver);
        Invoker invoker = new Invoker(cmd);
        invoker.action();
    }
}
