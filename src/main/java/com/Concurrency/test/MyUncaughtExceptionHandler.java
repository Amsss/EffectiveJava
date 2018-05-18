package com.Concurrency.test;

public class MyUncaughtExceptionHandler implements
		Thread.UncaughtExceptionHandler {

	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("caught " + e);
	}

}
