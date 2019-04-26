package com.collection.vector;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-25 14:50
 */
public class Dog {
    private int dogNumber;
    Dog(int i) {
        dogNumber = i;
    }
    void print() {
        System.out.println("Dog #" + dogNumber);
    }
}
