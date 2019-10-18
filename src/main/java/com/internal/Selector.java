package com.internal;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-23 17:12
 */
public interface Selector {
    boolean end();

    Object current();

    void next();
}
