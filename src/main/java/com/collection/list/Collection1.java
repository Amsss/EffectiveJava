package com.collection.list;

import java.util.Collection;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-28 10:31
 */
public class Collection1 {
    public static Collection
    fill(Collection c, int start, int size) {
        for (int i = start; i < start + size; i++) {
            c.add(Integer.toString(i));
        }
        return c;
    }

    // Default to a "start" of 0:
    public static Collection
    fill(Collection c, int size) {
        return fill(c, 0, size);
    }
}
