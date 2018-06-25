package com.ClassLoading.PassiveReference;

/**
 * @Description: 被动使用类字段演示一：通过子类引用父类的静态字段，不会导致子类初始化
 * @author: zhuzz
 * @date: 2018-06-12 15:31
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(SubClass.superSuperValue);
    }
}
