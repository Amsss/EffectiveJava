package com.concurrent.test;

public class ExceptionThread implements Runnable{

	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("run() by" + t);
		System.out.println("eh = " + t.getUncaughtExceptionHandler());
		throw new RuntimeException();
	}

}
