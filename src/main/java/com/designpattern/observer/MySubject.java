package com.designpattern.observer;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:50
 */
public class MySubject extends AbstractSubject {

    @Override
    public void operation() {
        System.out.println("update self!");
        notifyObservers();
    }

} 
