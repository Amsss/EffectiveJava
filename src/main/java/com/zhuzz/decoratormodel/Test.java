package com.zhuzz.decoratormodel;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Set<Date> s = new InstrumentedSet<Date>(new TreeSet<Date>());

        Set<String> s2 = new InstrumentedSet<String>(new HashSet<String>());

    }
}
