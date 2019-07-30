package com.collection.map;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-26 10:42
 */
public class testIterator {
    public Set<Integer> keySet() {

        final ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);
        result.add(2);
        result.add(3);

        Set<Integer> keySet = new AbstractSet<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    private Iterator<Integer> i = result.iterator();

                    @Override
                    public boolean hasNext() {
                        return i.hasNext();
                    }

                    @Override
                    public Integer next() {
                        return i.next();
                    }

                    @Override
                    public void remove() {
                        i.remove();
                    }
                };
            }

            @Override
            public int size() {
                return 0;
            }
        };

        return keySet;
    }
}
