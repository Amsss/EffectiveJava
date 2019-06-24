package com.bulider;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018/12/24 19:45
 */
public interface Builder<T> {

    /**
     * 构建方法
     *
     * @return T
     */
    T build();
}
