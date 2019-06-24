package com.collection;

import java.util.*;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-29 9:47
 */
public class ReadOnly {
    public static void main(String[] args) {
        Collection c = new ArrayList(16);
        // Reading OK, Can't change it
        c = Collections.unmodifiableCollection(c);
        List a = new ArrayList(16);
        // Reading OK, Can't change it
        a = Collections.unmodifiableList(a);
        Set s = new HashSet(16);
        // Reading OK, Can't change it
        s = Collections.unmodifiableSet(s);
        Map m = new HashMap(16);
        // Reading OK, Can't change it
        m = Collections.unmodifiableMap(m);
    }
}