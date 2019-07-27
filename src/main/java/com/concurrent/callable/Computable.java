package com.concurrent.callable;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 10:50
 */
public interface Computable<A, V> {
    /**
     * @param arg
     * @return
     * @throws InterruptedException
     */
    V compute(A arg) throws InterruptedException;
}
