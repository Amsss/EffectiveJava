package com.java8.serialization;

import java.io.Serializable;
import java.util.Comparator;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-07-04 23:58
 */
public class ComparatorFactory implements Serializable {
    public Comparator makeComparator() {
        return (Comparator & Serializable) (x, y) -> Integer.compareUnsigned((int) x, (int) y);
    }
}
