package com.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 10:47
 */
public class WriteCorrectThreadPool extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "1");
        try {
            ThreadPoolExecutor producerPool = new ThreadPoolExecutor(25, 40, 0, TimeUnit.SECONDS, new ArrayBlockingQueue(3), new ThreadPoolExecutor.DiscardOldestPolicy());
            int i = 0;
            //Thread.sleep(50000);
            while (i < 15) {
                try {
                    Thread.sleep(1000);
                    producerPool.submit(new WriteCorrectThread());
					/*i++;
					Thread.sleep(1000);*/
                    producerPool.submit(new PushDataThread());
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            producerPool.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new WriteCorrectThreadPool().start();
    }
}
