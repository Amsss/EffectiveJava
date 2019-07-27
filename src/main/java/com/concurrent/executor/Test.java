package com.concurrent.executor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @description: 不建议ExecutorService ex = Executors.newFixedThreadPool(7); 一遍需要手动创建
 * @author: zhuzz
 * @date: 2019/1/7 10:44
 */
public class Test {
    public static void main(String[] args) {
        /*ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService pool = new ThreadPoolExecutor(7, 7,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(10), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        String outPut = "";
            *//*outPut = *//*
        Future<String> future1 = pool.submit(new Callable<String>() {
                @Override
                public String call() {
                    while (true){
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            System.out.println("AHHHHH...我被中断了");
                            e.printStackTrace();
                        }
                    }
                }
            });
        try {
            future1.get(1,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("attempt to shutdown executor");
            pool.shutdown();
            pool.awaitTermination(10, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!pool.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            pool.shutdownNow();
            System.out.println("shutdown finished");
        }
        System.exit(0);
        System.out.println(outPut);*/

        /*ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3");
        try {
            executor.invokeAll(callables)
                    .stream()
                    .map(future -> {
                        try {
                            return future.get();
                        }
                        catch (Exception e) {
                            throw new IllegalStateException(e);
                        }
                    })
                    .forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            String x = executor.invokeAny(callables);
            System.out.println(x);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }*/

        ScheduledExecutorService executor1 =                 Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
        ScheduledFuture<?> future = executor1.schedule(task, 3, TimeUnit.SECONDS);

        try {
            TimeUnit.MILLISECONDS.sleep(1337);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining Delay: %sms", remainingDelay);

    }
}
