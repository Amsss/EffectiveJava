package com.designpattern.singleton.demo;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:55
 */
public class StaticSingleton {
    private StaticSingleton() {
        System.out.println("LazySingleton is create");
    }

    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    private static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
