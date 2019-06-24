package com.designpattern.observer;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:51
 */
public class Observer1 implements Observer {

    @Override
    public void update() {
        System.out.println("observer1 has received!");
    }
}
