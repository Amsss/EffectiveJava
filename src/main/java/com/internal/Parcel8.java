package com.internal;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-23 17:09
 */
public class Parcel8 {
    // Argument must be final to use inside
    // anonymous inner class:
    public Destination dest(String dest) {
        return new Destination() {
            private String label = dest;
            @Override
            public String readLabel() { return label; }
        };
    }
    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Destination d = p.dest("Tanzania");
    }
}
