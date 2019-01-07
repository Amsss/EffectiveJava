package com.concurrent.test1;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 10:55
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
