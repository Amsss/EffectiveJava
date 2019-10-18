package com.collection.vector;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-25 14:49
 */
public class Cat {
    private int catNumber;

    Cat(int i) {
        catNumber = i;
    }

    void print() {
        System.out.println("Cat #" + catNumber);
    }

    public static void main(String[] args) {
        Vector cats = new Vector();
        cats.elements();
        for (int i = 0; i < 7; i++) {
            cats.addElement(new Cat(i));
        }
        // Not a problem to add a dog to cats:
        cats.addElement(new Dog(7));
        Enumeration e = cats.elements();
        while (e.hasMoreElements()) {
            ((Cat) e.nextElement()).print();
        }
        // Dog is detected only at run-time
    }
}
