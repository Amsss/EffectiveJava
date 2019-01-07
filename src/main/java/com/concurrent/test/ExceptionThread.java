package com.concurrent.test;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 10:46
 */
public class ExceptionThread implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by" + t);
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }

}
