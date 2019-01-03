package com.designpattern.singleton.demo;

/**
 * @Author: Zezhao.Zhu
 * @Description:
 * @Create: 2018/5/25 11:46
 * @Modified By：
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
