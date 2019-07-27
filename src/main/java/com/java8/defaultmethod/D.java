package com.java8.defaultmethod;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-03-01 9:52
 */
public interface D {
    /**
     *
     */
    default void hello() {
        System.out.println("hello world from interface D");
    }
}
