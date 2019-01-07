package com.designpattern.memento;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:45
 */
public class Memento {

    private String value;

    public Memento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
