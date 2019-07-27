package com.concurrent.caughtexception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 捕获线程中的异常
 * @author: zhuzz
 * @date: 2019/1/3 16:03
 */
public class CaptureUncaughtException {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(1, new HandlerThreadFactory());
        exec.execute(new ExceptionThread());
    }
}
