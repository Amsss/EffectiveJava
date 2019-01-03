package com.concurrent.local;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/3 16:02
 */
public class Accessor implements Runnable {

    public Accessor(int id) {
        super();
        this.id = id;
    }

    private final int id;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    @Override
    public String toString() {
        return "#" + id + ": " + ThreadLocalVariableHolder.get();
    }
}
