package com.clone.shallow;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @description: “简单复制”或者“浅层复制”
 * @author: zhuzz
 * @date: 2019-06-11 15:22
 */
public class Cloning {
    public static void main(String[] args) {
        Vector<Int> v = new Vector<>();
        if(v instanceof Cloneable) {
            System.out.println("ok");
        }
        for (int i = 0; i < 10; i++) {
            v.addElement(new Int(i));
        }
        System.out.println("v: " + v);
        Vector v2 = (Vector) v.clone();
        // Increment all v2's elements:
        for (Enumeration e = v2.elements();
             e.hasMoreElements(); ) {
            ((Int) e.nextElement()).increment();
        }
        // See if it changed v's elements:
        System.out.println("v: " + v);
    }
}
