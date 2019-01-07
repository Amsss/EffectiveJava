package com.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 10:53
 */
public class ProLoader {

    private final FutureTask future = new FutureTask(new Callable<String>() {

        @Override
        public String call() throws Exception {
            // TODO Auto-generated method stub
            return null;
        }
    });
}
