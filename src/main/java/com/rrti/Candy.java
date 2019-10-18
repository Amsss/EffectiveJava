package com.rrti;

/**
 * @description: 用 newInstance()创建的类必须有一个默认构建器
 * @author: zhuzz
 * @date: 2019-05-06 10:16
 */
public class Candy {
    public Candy(String AA) {
        System.out.println(AA);
    }

    static {
        System.out.println("Loading Candy");
    }

    public static void main(String[] args) {
        try {
            Candy.class.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
