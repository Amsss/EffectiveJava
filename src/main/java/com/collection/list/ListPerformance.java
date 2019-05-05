package com.collection.list;

import java.util.*;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-28 10:25
 */
public class ListPerformance {
    private static final int REPS = 100;

    private abstract static class Tester {
        String name;
        // Test quantity
        int size;

        Tester(String name, int size) {
            this.name = name;
            this.size = size;
        }

        abstract void test(List a);
    }

    private static Tester[] tests = {
            new Tester("get", 300) {
                @Override
                void test(List a) {
                    for (int i = 0; i < REPS; i++) {
                        for (int j = 0; j < a.size(); j++) {
                            a.get(j);
                        }
                    }
                }
            },
            new Tester("iteration", 300) {
                @Override
                void test(List a) {
                    for (int i = 0; i < REPS; i++) {
                        Iterator it = a.iterator();
                        while (it.hasNext()) {
                            it.next();
                        }
                    }
                }
            },
            new Tester("insert", 1000) {
                @Override
                void test(List a) {
                    int half = a.size() / 2;
                    String s = "test";
                    ListIterator it = a.listIterator(half);
                    for (int i = 0; i < size * 10; i++) {
                        it.add(s);
                    }
                }
            },
            new Tester("remove", 5000) {
                @Override
                void test(List a) {
                    ListIterator it = a.listIterator(3);
                    while (it.hasNext()) {
                        it.next();
                        it.remove();
                    }
                }
            }
    };

    public static void test(List a) {
        // A trick to print out the class name:
        System.out.println("Testing " + a.getClass().getName());
        for (int i = 0; i < tests.length; i++) {
            Collection1.fill(a, tests[i].size);
            System.out.print(tests[i].name);
            long t1 = System.currentTimeMillis();
            tests[i].test(a);
            long t2 = System.currentTimeMillis();
            System.out.println(": " + (t2 - t1));
        }
    }

    public static void main(String[] args) {
        test(new ArrayList());
        test(new LinkedList());
    }
}