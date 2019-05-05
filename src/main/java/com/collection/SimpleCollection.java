package com.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-26 15:50
 */
public class SimpleCollection {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        for(int i = 0; i < 10; i++) {
            c.add(Integer.toString(i));
        }
        for (Object aC : c) {
            System.out.println(aC);
        }
    }
}