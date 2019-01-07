package com.designpattern.command;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:28
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action() {
        command.exe();
    }
}
