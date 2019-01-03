package com.concurrent.threadLocal;

/**
 * @description: ThreadLocal测试
 * @author: zhuzz
 * @date: 2018-06-25 9:49
 */
public class MyThreadLocal {

    /**
     * 避免弱引用
     */
    private static final ThreadLocal<Object> THREAD_LOCAL = new ThreadLocal<Object>() {
        /**
         * ThreadLocal没有被当前线程赋值时或当前线程刚调用remove方法后调用get方法，返回此方法值
         */
        @Override
        protected Object initialValue() {
            System.out.println("调用get方法时，当前线程共享变量没有设置，调用initialValue获取默认值！");
            return null;
        }
    };

    public static void main(String[] args) {
        new Thread(new MyIntegerTask("IntegerTask1")).start();
        new Thread(new MyStringTask("StringTask1")).start();
        new Thread(new MyIntegerTask("IntegerTask2")).start();
        new Thread(new MyStringTask("StringTask2")).start();
    }

    public static class MyIntegerTask implements Runnable {

        private String name;

        MyIntegerTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                // threadLocal.get方法获取线程变量
                if (null == MyThreadLocal.THREAD_LOCAL.get()) {
                    // threadLocal.et方法设置线程变量
                    MyThreadLocal.THREAD_LOCAL.set(0);
                    System.out.println("线程" + name + ": 0");
                } else {
                    int num = (Integer) MyThreadLocal.THREAD_LOCAL.get();
                    MyThreadLocal.THREAD_LOCAL.set(num + 1);
                    System.out.println("线程" + name + ": " + MyThreadLocal.THREAD_LOCAL.get());
                    if (i == 3) {
                        MyThreadLocal.THREAD_LOCAL.remove();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class MyStringTask implements Runnable {

        private String name;

        MyStringTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                if (null == MyThreadLocal.THREAD_LOCAL.get()) {
                    MyThreadLocal.THREAD_LOCAL.set("a");
                    System.out.println("线程" + name + ": a");
                } else {
                    String str = (String) MyThreadLocal.THREAD_LOCAL.get();
                    MyThreadLocal.THREAD_LOCAL.set(str + "a");
                    System.out.println("线程" + name + ": " + MyThreadLocal.THREAD_LOCAL.get());
                }
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
