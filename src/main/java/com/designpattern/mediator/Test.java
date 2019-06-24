package com.designpattern.mediator;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:40
 */
public class Test {

    public static void main(String[] args) {
        Mediator mediator = new MyMediator();
        mediator.createMediator();
        mediator.workAll();
    }
}
