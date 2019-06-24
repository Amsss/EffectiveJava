package com.internal;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-23 17:06
 */
public class Parcel7 {
    public Wrapping wrap(int x) {
        // Base constructor call:
        return new Wrapping(x) {
            @Override
            public int value() {
                return super.value() * 47;
            }
        }; // Semicolon required
    }
    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Wrapping w = p.wrap(10);
        System.out.println(w.value());
    }
}
