package com.collection.map;

import java.util.AbstractSet;
import java.util.Iterator;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-26 10:46
 */
public class mySet extends AbstractSet<Integer> {

    private Iterator<Integer> iter;

    public mySet(Iterator<Integer> i) {
        iter = i;
    }

    @Override
    public Iterator<Integer> iterator() {
        return iter;
    }

    @Override
    public int size() {
        return 0;
    }

}
