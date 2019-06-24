package com.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-28 10:47
 */
public class Unsupported {
    private static String[] s = {
            "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten",
    };
    static List a = Arrays.asList(s);
    static List a2 = Arrays.asList(new String[] { s[3], s[4], s[5] });
    public static void main(String[] args) {
        print(a); // Iteration
        System.out.println(
                "a.contains(" + s[0] + ") = " +
                        a.contains(s[0]));
        System.out.println(
                "a.containsAll(a2) = " +
                        a.containsAll(a2));
        System.out.println("a.isEmpty() = " +
                a.isEmpty());
        System.out.println(
                "a.indexOf(" + s[5] + ") = " +
                        a.indexOf(s[5]));
        // Traverse backwards:
        ListIterator lit = a.listIterator(a.size());
        while(lit.hasPrevious()) {
            System.out.print(lit.previous());
        }
        System.out.println();
        // Set the elements to different values:
        for(int i = 0; i < a.size(); i++) {
            a.set(i, "47");
        }
        print(a);
        // Compiles, but won't run:
        lit.add("X"); // Unsupported operation
        a.clear(); // Unsupported
        a.add("eleven"); // Unsupported
        a.addAll(a2); // Unsupported
        a.retainAll(a2); // Unsupported
        a.remove(s[0]); // Unsupported
        a.removeAll(a2); // Unsupported
    }

    public static void print(Collection c) {
        for (Object aC : c) {
            System.out.print(aC + " ");
        }
        System.out.println();
    }
}