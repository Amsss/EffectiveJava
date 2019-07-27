package com.java8.methodreference;

/**
 * @description: 函数式接口
 * @author: zhuzz
 * @date: 2019-02-28 10:08
 */
@FunctionalInterface
public interface IConvert<F, T> {
    /**
     * 转换
     *
     * @param form
     * @return
     */
    T convert(F form);
}
