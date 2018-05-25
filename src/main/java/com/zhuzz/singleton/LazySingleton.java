package com.zhuzz.singleton;

/**
 * @Author: Zezhao.Zhu
 * @Description:
 * @Create: 2018/5/25 11:46
 * @Modified By：
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
