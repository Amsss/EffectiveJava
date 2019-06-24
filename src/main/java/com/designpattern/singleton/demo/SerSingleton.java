package com.designpattern.singleton.demo;

import java.io.Serializable;

/**
 * @description: 单例模式（弊端：在该类其他静态方法被调用的时候也会实例化--没有延迟加载机制）
 * @author: zhuzz
 * @date: 2019/1/7 11:55
 */
public class SerSingleton implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private SerSingleton() {
        System.out.println("LazySingleton is create");
    }

    private static final SerSingleton INSTANCE = new SerSingleton();

    public static SerSingleton getInstance() {
        return INSTANCE;
    }

    /**
     * 如果该对象被用于序列化，可以保证对象在序列化前后保持一致
     *
     * @return
     */
    public Object readResolve() {
        return INSTANCE;
    }

}
