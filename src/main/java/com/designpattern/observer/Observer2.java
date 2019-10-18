package com.designpattern.observer;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:54
 */
public class Observer2 implements Observer {

    @Override
    public void update() {
        System.out.println("observer2 has received!");
    }

}
