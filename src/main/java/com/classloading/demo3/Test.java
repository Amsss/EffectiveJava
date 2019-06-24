package com.classloading.demo3;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @description: 外部类可以访问内部类的所有方法与属性，包括私有方法与属性
 * @author: zhuzz
 * @date: 2019/1/7 10:43
 */
public class Test {

    private String name;
    private int age = 1;
    public static int age1 = 1;
    private static String country = "cn";
    private AtomicBoolean abc;

    Test(String name, int age) {
        System.out.println("构造函数");
        this.name = name;
        this.age = age;
    }

    static {
        System.out.println("静态代码块被执行");
    }

    {
        System.out.println(name + "..." + age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println(this.name + "..." + this.age);
    }

    public static void showCountry() {
        StaticDemo staticDemo = new StaticDemo();
        staticDemo.test();
        System.out.println("country=" + country);
    }

    public static void main(String[] args) {
        showCountry();
    }


    static class StaticDemo {

        public static void main(String[] args) {
            System.out.println(age1);
            Test p = new Test("张三", 100);
            p.setName("李四");
            p.speak();
            Test.showCountry();
        }

        private void test() {
            System.out.println("111");
        }

        static {
            System.out.println("StaticDemo 静态代码块1");
        }

        static {
            System.out.println("StaticDemo 静态代码块2");
        }

    }

    public class StaticDemo1 {

        public void main(String[] args) {
            Test p = new Test("张三", 100);
            p.setName("李四");
            p.speak();
            Test.showCountry();
        }

        private void test() {

            System.out.println("111");
        }

        {
            System.out.println("StaticDemo 静态代码块1");
        }

        {
            System.out.println("StaticDemo 静态代码块2");
        }

    }
}
