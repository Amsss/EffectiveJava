package com.designpattern.observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:50
 */
public abstract class AbstractSubject implements Subject {

    private Vector<Observer> vector = new Vector<Observer>();

    @Override
    public void add(Observer observer) {
        vector.add(observer);
    }

    @Override
    public void del(Observer observer) {
        vector.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<Observer> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            enumeration.nextElement().update();
        }
    }
}
