package com.java8.defaultmethod;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-03-01 9:47
 */
public interface A {
    /**
     *
     */
    void doSomething();

    /**
     *
     */
    default void hello() {
        System.out.println("hello world from interface Test");
    }

    /**
     *
     */
    default void foo() {
        System.out.println("foo from interface Test");
    }
}
