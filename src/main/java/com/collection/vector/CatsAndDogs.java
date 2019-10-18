package com.collection.vector;

import java.util.Iterator;
import java.util.Vector;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-25 14:50
 */
public class CatsAndDogs {
    public static void main(String[] args) {
        //TODO
        Vector cats = new Vector();
        Iterator iterator = cats.iterator();
        for (int i = 0; i < 7; i++) {
            cats.addElement(new Cat(i));
        }
        // Not a problem to add a dog to cats:
        cats.addElement(new Dog(7));
        for (int i = 0; i < cats.size(); i++) {
            ((Cat) cats.elementAt(i)).print();
        }
        // Dog is detected only at run-time
    }
}
