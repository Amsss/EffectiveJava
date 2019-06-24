package com.clone.shallow;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-06-11 15:58
 */
public class Int2 implements Cloneable {
    private int i;

    public Int2(int ii) {
        i = ii;
    }

    public void increment() {
        i++;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }

    @Override
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Int2 can't clone");
        }
        return o;
    }
}
