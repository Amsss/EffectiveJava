package com.classLoading;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AA {

    private static final String[] PRIVATE_VALUES = {"aa", "bb"};
    public static final List<String> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

    public static String[] VALUES() {
        return PRIVATE_VALUES.clone();
    }

    public static List<Integer> intArrayAsList(final int[] a) {

        if (a == null) {
            throw new NullPointerException();
        }
        return new AbstractList<Integer>() {

            @Override
            public Integer get(int index) {
                return a[index];
            }

            @Override
            public Integer set(int index, Integer val) {
                int oldVal = a[index];
                a[index] = val;
                return oldVal;
            }

            @Override
            public int size() {
                return a.length;
            }
        };
    }

    public static void main(String[] args) {
        List<Integer> a = AA.intArrayAsList(new int[]{1, 2, 3});
    }
}
