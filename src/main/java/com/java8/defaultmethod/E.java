package com.java8.defaultmethod;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-03-01 9:52
 */
public interface E {
    default void hello() {
        System.out.println("Hello from E");
    }
}
