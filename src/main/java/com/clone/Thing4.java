package com.clone;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-06-11 16:05
 */
public class Thing4 implements Cloneable {
    Thing3 o3 = new Thing3();

    @Override
    public Object clone() {
        Thing4 o = null;
        try {
            o = (Thing4) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Thing4 can't clone");
        }
        // Clone the field, too:
        o.o3 = (Thing3) o3.clone();
        return o;
    }
}
