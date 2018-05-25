package com.zhuzz.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(7);
        String outPut = "";
        try {
            outPut = ex.submit(new Callable<String>() {
                public String call() throws Exception {
                    while (true) {

                    }
                };
            }).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(outPut);
    }
}
