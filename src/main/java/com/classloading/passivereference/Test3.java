package com.classloading.passivereference;

/**
 * @description: 被动使用类字段演示三：常量在编译阶段会存入调用类的常量池中，
 * 本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
 * @author: zhuzz
 * @date: 2018-06-12 15:31
 */
public class Test3 {
    public static void main(String[] args) {
        System.out.println(SuperClass.HELLO);
    }
}
