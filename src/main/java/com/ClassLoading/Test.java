package com.ClassLoading;

import java.util.concurrent.atomic.AtomicBoolean;

public class Test {

    private String name;
    private int age = 0;
    private static String country = "cn";
    private AtomicBoolean abc;

    Test(String name, int age) {
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
        System.out.println("country=" + country);
    }


    static class StaticDemo {

        public static void main(String[] args) {
            Test p = new Test("张三", 100);
            p.setName("李四");
            p.speak();
            Test.showCountry();
        }

        static {
            System.out.println("StaticDemo 静态代码块1");
        }

        static {
            System.out.println("StaticDemo 静态代码块2");
        }

    }
}
