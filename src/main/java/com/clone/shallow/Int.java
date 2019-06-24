package com.clone.shallow;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-06-11 15:22
 */
public class Int {
    private int i;

    public Int(int ii) {
        i = ii;
    }

    public void increment() {
        i++;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}
