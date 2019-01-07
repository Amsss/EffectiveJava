package com.designpattern.iterator;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:37
 */
public interface Collection {
    /**
     * @return
     */
    Iterator iterator();

    /**
     * 取得集合元素
     *
     * @param i
     * @return
     */
    Object get(int i);

    /**
     * 取得集合大小
     *
     * @return
     */
    int size();
}
