package com.collection;

import com.collection.array.AlphaComp;
import com.collection.array.Array1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-28 13:49
 */
public class ListSort {
    public static void main(String[] args) {
        final int SZ = 20;
        // Using "natural comparison method":
        List a = new ArrayList();
        for(int i = 0; i < SZ; i++) {
            a.add(new CompClass(
                    (int)(Math.random() *100)));
        }
        Collections.sort(a);
        Object find = a.get(SZ/2);
        int loc = Collections.binarySearch(a, find);
        System.out.println("Location of " + find +
                " = " + loc);
        // Using a Comparator:
        List b = new ArrayList();
        for(int i = 0; i < SZ; i++) {
            b.add(Array1.randString(4));
        }
        AlphaComp ac = new AlphaComp();
        Collections.sort(b, ac);
        find = b.get(SZ/2);
        // Must use the Comparator to search, also:
        loc = Collections.binarySearch(b, find, ac);
        System.out.println("Location of " + find +
                " = " + loc);
    }
}
