package com.designpattern.singleton.demo;

import java.io.Serializable;

/**
 * @description: 单例模式（弊端：在该类其他静态方法被调用的时候也会实例化--没有延迟加载机制）
 * @author: zhuzz
 * @date: 2019/1/7 11:55
 */
public class Singleton implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Singleton() {
        System.out.println("LazySingleton is create");
    }

    private static final Singleton INSTANCE = new Singleton();

    public static Singleton getInstance() {
        return INSTANCE;
    }

    public Object readResolve() {
        return INSTANCE;
    }
}
