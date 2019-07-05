package com.java8.longadder;

import java.util.concurrent.atomic.LongAdder;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-07-05 23:13
 */
public class Test {
    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        System.out.println(longAdder.intValue());
    }
}
