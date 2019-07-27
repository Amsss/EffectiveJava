package com.concurrent.caughtexception;

import java.util.concurrent.ThreadFactory;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 10:46
 */
public class HandlerThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("create " + t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        return t;
    }

}
