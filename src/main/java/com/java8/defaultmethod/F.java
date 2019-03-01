package com.java8.defaultmethod;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-03-01 9:52
 */
public class F implements D, E {
    @Override
    public void hello(){
        D.super.hello();
    }
}
