package com.concurrent.synchronizedtest;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 10:45
 */
public class MyClass {

    public static synchronized void log1(String msg1, String msg2) {
        try {

            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(msg1);
        System.out.println(msg2);
    }

    public static synchronized void log3(String msg1, String msg2) {
        System.out.println(msg1);
        System.out.println(msg2);
    }

    public static void log2(String msg1, String msg2) {
        synchronized (MyClass.class) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(msg1);
            System.out.println(msg2);
        }
    }

    public static void log4(String msg1, String msg2) {
        synchronized (MyClass.class) {

            System.out.println(msg1);
            System.out.println(msg2);
        }
    }

    public void log5(String msg1, String msg2) {
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(msg1);
            System.out.println(msg2);
        }
    }

    public void log6(String msg1, String msg2) {
        synchronized (this) {
            System.out.println(msg1);
            System.out.println(msg2);
        }
    }

}