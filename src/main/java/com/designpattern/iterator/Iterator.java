package com.designpattern.iterator;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:38
 */
public interface Iterator {

    /**
     * 前移
     *
     * @return
     */
    Object previous();

    /**
     * 后移
     *
     * @return
     */
    Object next();

    /**
     * @return
     */
    boolean hasNext();

    /**
     * 取得第一个元素
     *
     * @return
     */
    Object first();
}
