package com.designpattern.singleton;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:56
 */
public class SingletonTest {
    private static SingletonTest instance = null;

    private SingletonTest() {
    }

    private static synchronized void syncInit() {
        if (instance == null) {
            instance = new SingletonTest();
        }
    }

    public static SingletonTest getInstance() {
        if (instance == null) {
            syncInit();
        }
        return instance;
    }
}	
