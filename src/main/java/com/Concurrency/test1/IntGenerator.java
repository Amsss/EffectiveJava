package com.Concurrency.test1;

/**
 * @author zhuzz
 * @类功能说明:
 * @创建时间:2018-2-26 下午4:27:56
 */
public abstract class IntGenerator {
	private volatile boolean canceled = false;

	public abstract int next();

	public void cancel() {
		canceled = true;
	}

	public boolean isCanceled() {
		return canceled;
	}
}
