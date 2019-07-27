package com.concurrent.volatiledemo;

/**
 * @description: volatile是如何工作的。
 * 成员变量boolValue使用volatile和不使用volatile会有明显区别的。
 * 本程序需要多试几次，就能知道两者之间的区别的。
 * @author: zhuzz
 * @date: 2019/1/7 10:50
 */
public class VolatileObjectTest {

    private boolean boolValue;

    /**
     * 加上volatile修饰的是时候，程序会很快退出，
     * 因为volatile保证各个线程工作内存的变量值和主存一致。所以boolValue==!boolValue就成为了可能。
     */
    public void waitToExit() {
        if (boolValue == !boolValue) {
            System.exit(0);
        }
        // 非原子操作，理论上应该很快会被打断。实际不是，因为此时的boolValue在线程自己内部的工作内存的拷贝，
        // 因为它不会强制和主存区域同步，线程2修改了boolValue很少有机会传递到线程一的工作内存中。所以照成了假的“原子现象”。
    }

    public void swap() {
        // 不断反复修改boolValue，以期打断线程1.
        boolValue = !boolValue;
    }

    public static void main(String[] args) {
        final VolatileObjectTest TestvolObj = new VolatileObjectTest();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println("t1start");
                for (; ; ) {
                    TestvolObj.waitToExit();
                }
            }
        };
        t2.start();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("t2start");
                for (; ; ) {
                    TestvolObj.swap();
                }
            }
        };
        t1.start();
    }
}