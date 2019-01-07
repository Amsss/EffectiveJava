package com.designpattern.singleton.demo;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:54
 */
public class LazySingleton {
    private LazySingleton() {
        System.out.println("LazySingleton is create");
    }

    private static LazySingleton instance = null;

    private static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
