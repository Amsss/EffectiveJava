package com.clone;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-06-11 16:05
 */
public class Thing3 implements Cloneable {

    @Override
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Thing3 can't clone");
        }
        return o;
    }
}
