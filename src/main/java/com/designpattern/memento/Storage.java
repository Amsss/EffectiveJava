package com.designpattern.memento;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:46
 */
public class Storage {

    private Memento memento;

    public Storage(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
