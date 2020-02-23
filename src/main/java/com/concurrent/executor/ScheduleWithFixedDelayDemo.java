package com.concurrent.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @description: scheduleWithFixedDelay 比如当前一个任务结束的时刻，开始结算间隔时间，如10秒开始执行第一次任务，
 * 任务耗时2秒，任务间隔时间100秒，那么第二次任务执行的时间是在第 秒开始。
 * @author: zhuzz
 * @date: 2019-07-06 16:39
 */
public class ScheduleWithFixedDelayDemo {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling: " + System.nanoTime());
            } catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        };
        executor.scheduleWithFixedDelay(task, 10, 100, TimeUnit.SECONDS);
    }
}
