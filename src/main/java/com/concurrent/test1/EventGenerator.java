package com.concurrent.test1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 10:56
 */
public class EventGenerator extends IntGenerator{
	private int currentEventValue = 0;
	private ReentrantLock lock = new ReentrantLock();
	@Override
	public int next() {
		++currentEventValue;
		++currentEventValue;
		return currentEventValue;
	}
	public static void main(String[] args) {
		EvenChecker.test(new EventGenerator());
	}
}
