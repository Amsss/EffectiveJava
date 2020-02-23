package com.closeable;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-08-28 9:19
 */
public class ConnectionInnerLock implements ConnectionLock {

    @Override
    public void unlock() {
        //do release resource
        System.out.println("release resource ");
    }

    @Override
    public void close() throws Exception {
        this.unlock();
    }
}
