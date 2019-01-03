/**
 * @文件名：WriteCorrectThreadPool.java 
 * @作者:zhuzz
 * @创建时间： 2018-1-24 下午10:43:16
 * @版本:V1.0
 * 版权：版权所有 bsoft 保留所有权力。
 */
package com.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuzz
 * @类功能说明:
 * @创建时间:2018-1-24 下午10:43:16
 */

public class WriteCorrectThreadPool extends Thread {
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"1");
		try {
			ThreadPoolExecutor producerPool = new ThreadPoolExecutor(25, 40, 0, TimeUnit.SECONDS, new ArrayBlockingQueue(3), new ThreadPoolExecutor.DiscardOldestPolicy());
			int i=0;
			//Thread.sleep(50000);
			while(i < 15){
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
