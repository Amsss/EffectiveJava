package com.datastructures.stack;

import com.datastructures.Person;

import java.util.Stack;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018-09-11 12:19
 */
public class TestStack {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Stack stack = new Stack();
        if (!stack.empty()) {
            stack.pop();
        }
        StackDemo<Person> queue = new StackDemo<>();
        for (int i = 0; i < 10; i++) {
            Person p = new Person("zhang" + i, "m");
            queue.add(p);
        }
        queue.print();
        System.out.println("=====");
        while (queue.size() > 0) {
            queue.remove();
            queue.print();
            System.out.println("=====");
        }
    }
}
