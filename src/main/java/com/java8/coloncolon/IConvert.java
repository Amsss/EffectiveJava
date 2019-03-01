package com.java8.coloncolon;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-02-28 10:08
 */
@FunctionalInterface
public interface IConvert<F, T> {
    T convert(F form);
}
