package com.concurrent.lock.syn;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 10:44
 */
public class ExecutorTest {
    public static void main(String args[]) {
        Random random = new Random();
        //产生一个 ExecutorService 对象，这个对象带有一个大小为 poolSize 的线程池，若任务数量大于 poolSize ，任务会被放在一个 queue 里顺序执行。   
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // 判断可是线程池可以结束  
        int waitTime = 500;
        for (int i = 0; i < 10; i++) {
            String name = "线程 " + i;
            int time = random.nextInt(1000);
            waitTime += time;
            Runnable runner = new ExecutorThread(name, time);
            System.out.println("增加: " + name + " / " + time);
            executor.execute(runner);
        }
        try {
            Thread.sleep(waitTime);
            executor.shutdown();
            executor.awaitTermination(waitTime, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ignored) {
        }
    }
}

class ExecutorThread implements Runnable {
    private final String name;
    private final int delay;

    public ExecutorThread(String name, int delay) {
        this.name = name;
        this.delay = delay;
    }

    public void run() {
        System.out.println("启动: " + name);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ignored) {
        }
        System.out.println("完成: " + name);
    }
}
