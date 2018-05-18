package com.Concurrency.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CaptureUncaughtException {
	public static void main(String[] args) {
		//Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		//ExecutorService exec = Executors.newFixedThreadPool(1);
		ExecutorService exec = Executors.newFixedThreadPool(1, new HandlerThreadFactory());//newCachedThreadPool();
		exec.execute(new ExceptionThread());
	}
}
