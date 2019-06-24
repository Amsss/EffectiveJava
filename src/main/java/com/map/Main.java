package com.map;

import java.util.ArrayList;
import java.util.Set;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-26 10:43
 */
public class Main {
    public static void main(String[] args) {

        /*testIterator t = new testIterator();
        Set<Integer> set = t.keySet();
        System.out.println(set);*/
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(1);
        array.add(2);
        array.add(3);

        Set<Integer> set = new mySet(array.iterator());
        System.out.println(set);

    }
}
