package com.clone.shallow;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-06-11 15:59
 */
public class AddingClone {
    public static void main(String[] args) {
        Int2 x = new Int2(10);
        Int2 x2 = (Int2) x.clone();
        x2.increment();
        System.out.println("x = " + x + ", x2 = " + x2);
        // Anything inherited is also cloneable:
        Int3 x3 = new Int3(7);
        x3 = (Int3) x3.clone();
        Vector v = new Vector();
        for (int i = 0; i < 10; i++) {
            v.addElement(new Int2(i));
        }
        System.out.println("v: " + v);
        Vector v2 = (Vector) v.clone();
        // Now clone each element:
        for (int i = 0; i < v.size(); i++) {
            v2.setElementAt(((Int2) v2.elementAt(i)).clone(), i);
        }
        // Increment all v2's elements:
        for (Enumeration e = v2.elements(); e.hasMoreElements(); ) {
            ((Int2) e.nextElement()).increment();
        }
        // See if it changed v's elements:
        System.out.println("v: " + v);
        System.out.println("v2: " + v2);
    }
}
