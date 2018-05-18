package com.zhuzz.Synchronized;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class A {
	public static volatile int i = 0;
	    public static void main(String[] args) {
	        System.out.println("//================线程学习=================");
	        /**
	         * corePoolSize 池中所保存的线程数，包括空闲线程。需要注意的是在初创建线程池时线程不会立即启动，直到有任务提交才开始启动线程并逐渐时线程数目达到corePoolSize。
	         * 
	         * maximumPoolSize 池中允许的最大线程数。需要注意的是当核心线程满且阻塞队列也满时才会判断当前线程数是否小于最大线程数，并决定是否创建新线程。
	         * 
	         * keepAliveTime - 当线程数大于核心时，多于的空闲线程最多存活时间 
	         * 
	         * unit keepAliveTime 参数的时间单位。 
	         * 
	         * workQueue - 当线程数目超过核心线程数时用于保存任务的队列。主要有3种类型的BlockingQueue可供选择：无界队列，有界队列和同步移交
	         * 
	         * threadFactory - 执行程序创建新线程时使用的工厂。 
	         * 
	         * handler - 阻塞队列已满且线程数达到最大值时所采取的饱和策略。java默认提供了4种饱和策略的实现方式：中止、抛弃、抛弃最旧的、调用者运行。将在下文中详细阐述。
	         */
	       /* ThreadPoolExecutor threadPoolExecutornew = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<String>(10), new ThreadPoolExecutor.AbortPolicy(), handler)
	        *//**
	         * 若想一开始就创建所有核心线程需调用prestartAllCoreThreads方法。
	         *//*
	        threadPoolExecutornew.prestartAllCoreThreads();*/
	            /*Runnable runnable = new Runnable() {    
	                public void run() {    
	                    // task to run goes here    
	                    System.out.println("Hello !!");    
	                }    
	            };    
	            ScheduledExecutorService service = Executors    
	                    .newSingleThreadScheduledExecutor(); 
	            // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间    
	            service.scheduleAtFixedRate(runnable, 10, 1, TimeUnit.SECONDS);*/
	            
			for (int i = 0; i < 1000; i++) {
				new Thread() {
					public void run() {
						//Thread.yield();
						A.i++;
					}
				}.start();
			}
			System.out.println(A.i);
		}

	    static void pong() {
	        System.out.println("pong");
	    }
	    
}
