package com.concurrent.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @description: 就是每隔多少时间，固定执行任务
 * scheduleAtFixedRate ，是以上一个任务开始的时间计时，120秒过去后，检测上一个任务是否执行完毕，
 * 如果上一个任务执行完毕，则当前任务立即执行，
 * 如果上一个任务没有执行完毕，则需要等上一个任务执行完毕后立即执行。
 * @author: zhuzz
 * @date: 2019-07-06 16:38
 */
public class ScheduleAtFixedRateDemo {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = (() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Scheduling: " + System.nanoTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        int initialDelay = 0;
        int period = 5;
        executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
    }
}
