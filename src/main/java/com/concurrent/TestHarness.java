/**
 * @文件名：TestHarness.java
 * @作者:zhuzz
 * @创建时间： 2018-1-16 下午5:17:31
 * @版本:V1.0 版权：版权所有 bsoft 保留所有权力。
 */
package com.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * @author zhuzz
 * @类功能说明:
 * @创建时间:2018-1-16 下午5:17:31
 */

public class TestHarness {
    public static long TimeTask(int nThreads, final Runnable task) throws Exception {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(0);
        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread(() -> {
                try {
                    startGate.await();
                    try {
                        task.run();
                    } finally {
                        endGate.countDown();
                    }
                } catch (InterruptedException ignored) {

                }

            });
            t.sleep(1);
            t.start();
        }
        ;
        long start1 = System.currentTimeMillis();
        long start = System.nanoTime();
        //startGate.countDown();
        //endGate.await();
        long end1 = System.currentTimeMillis();
        long end = System.nanoTime();
        //1秒=1000豪秒 1毫秒=1000微秒 1微秒=1000毫微秒 1毫微秒＝1纳秒 1纳秒=10埃秒
        System.out.println(end1 - start1);
        System.out.println(end - start);
        return end - start;
    }

    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        long start = System.nanoTime();
        Map map = new HashMap<>(1024>>16);
        //startGate.countDown();
        //endGate.await();
        long end1 = System.currentTimeMillis();
        long end = System.nanoTime();
        //1秒=1000豪秒 1毫秒=1000微秒 1微秒=1000毫微秒 1毫微秒＝1纳秒 1纳秒=10埃秒
        System.out.println(end1 - start1);
        System.out.println(end - start);
        /*Runnable a = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        try {
            long time = TimeTask(10, a);
            System.out.println(time);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
		/*final CountDownLatch startGate = new CountDownLatch(1);
		startGate.countDown();
		try {
			startGate.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }
}