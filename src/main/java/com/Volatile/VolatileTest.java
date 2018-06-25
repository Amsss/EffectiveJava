package com.Volatile;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.TimeUnit;

/**
 * @Description: volatile变量多线程自增测试
 * @author: zhuzz
 * @date: 2018-06-24 9:39
 */
public class VolatileTest {
    public static final int THREADS_COUNT = 20;
    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        // 获取java线程的管理MXBean
        ThreadMXBean tmxb = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的Monitor和synchronizer信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = tmxb.dumpAllThreads(false, false);
        // 遍历线程信息，打印出ID和名称
        for (ThreadInfo info : threadInfos) {
            System.out.println("[" + info.getThreadId() + "] " + info.getThreadName());
        }
        //发现当前线程组包含：main和Monitor Ctrl-Break
        Thread.currentThread().getThreadGroup().list();
        while (Thread.activeCount() > 2) {
            /**
             *
             */
            System.out.println("其他活跃的线程数" + Thread.activeCount());
            /**
             * 线程让步：即让当前线程由“运行状态”进入到“就绪状态”从而让其它具有相同优先级的等待线程获取执行权；但是，并不能保
             * 证在当前线程调用yield()之后，其它具有相同优先级的线程就一定能获得执行权；也有可能是当前线程又进入到“运行状态”继续运行！
             */
            Thread.yield();
        }
        /*try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println(race);
    }
}
