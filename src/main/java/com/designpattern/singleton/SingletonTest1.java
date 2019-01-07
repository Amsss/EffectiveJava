package com.designpattern.singleton;

import java.util.Vector;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:56
 */
public class SingletonTest1 {

    private static SingletonTest1 instance = null;
    private Vector properties = null;

    public Vector getProperties() {
        return properties;
    }

    private SingletonTest1() {
    }

    private static synchronized void syncInit() {
        if (instance == null) {
            instance = new SingletonTest1();
        }
    }

    public static SingletonTest1 getInstance() {
        if (instance == null) {
            syncInit();
        }
        return instance;
    }

    public void updateProperties() {
        SingletonTest1 shadow = new SingletonTest1();
        properties = shadow.getProperties();
    }
}
