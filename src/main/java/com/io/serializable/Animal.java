package com.io.serializable;

import java.io.Serializable;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-05-05 17:33
 */
public class Animal implements Serializable {
    String name;
    House preferredHouse;
    Animal(String nm, House h) {
        name = nm;
        preferredHouse = h;
    }
    @Override
    public String toString() {
        return name + "[" + super.toString() +
                "], " + preferredHouse + "\n";
    }
}
