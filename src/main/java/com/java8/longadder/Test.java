package com.java8.longadder;

import java.util.concurrent.atomic.LongAdder;

/**
 * @description: LongAdder 替代 AtomicLong
 * LongAdder类与AtomicLong类的区别在于高并发时前者将对单一变量的CAS操作分散为对数组cells中多个元素的CAS操作，取值时进行求和；
 * 而在并发较低时仅对base变量进行CAS操作，与AtomicLong类原理相同。不得不说这种分布式的设计还是很巧妙的。
 * @author: zhuzz
 * @date: 2019-07-05 23:13
 */
public class Test {
    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        System.out.println(longAdder.intValue());
    }
}
