package com.closeable;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-08-28 9:19
 */
interface ConnectionLock extends AutoCloseable {

    /**
     * 释放资源
     */
    void unlock();
}
