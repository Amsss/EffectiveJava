package com.concurrent.caughtexception;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 10:56
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e);
    }
}
