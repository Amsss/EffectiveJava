package com.concurrent.exchanger;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;

/**
 * @description: 一般使用成双的线程来使用
 * Exchanger类仅可用作两个线程的信息交换，当超过两个线程调用同一个exchanger对象时，
 * 得到的结果是随机的，exchanger对象仅关心其包含的两个“格子”是否已被填充数据，当两个格子都填充数据完成时，
 * 该对象就认为线程之间已经配对成功，然后开始执行数据交换操作。
 * 而剩下的未得到配对的线程，则会被阻塞，永久等待，直到与之配对的线程到达位置，对于本程序，则只能强制将其停止。
 * @author: zhuzz
 * @date: 2019-07-27 18:00
 */
public class ExchangerTest extends Thread{
    private Exchanger<String> exchanger;
    private String string;
    private String threadName;
    private CountDownLatch countDownLatch;


    public ExchangerTest(Exchanger<String> exchanger, String string, String threadName, CountDownLatch countDownLatch) {
        this.exchanger = exchanger;
        this.string = string;
        this.threadName = threadName;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.println(threadName + ": " + exchanger.exchange(string));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CountDownLatch startGate = new CountDownLatch(1);
        Exchanger<String> exchanger = new Exchanger<>();
        ExchangerTest test1 = new ExchangerTest(exchanger, "string1", "thread-1",startGate);
        ExchangerTest test2 = new ExchangerTest(exchanger, "string2", "thread-2",startGate);
        ExchangerTest test3 = new ExchangerTest(exchanger, "string3", "thread-3",startGate);
        ExchangerTest test4 = new ExchangerTest(exchanger, "string4", "thread-4",startGate);
        test1.start();
        test2.start();
        test3.start();
        test4.start();
        startGate.countDown();
    }
}
