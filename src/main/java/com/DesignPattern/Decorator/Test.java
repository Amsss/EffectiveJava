package com.DesignPattern.Decorator;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/3 16:08
 */
public class Test {

    public static void main(String[] args) {
        Set<Date> s = new InstrumentedSet<Date>(new TreeSet<Date>());
        Set<String> s2 = new InstrumentedSet<String>(new HashSet<String>());
    }
}
