package com.DataStructures.stack;

import java.util.Arrays;

/**
 * @description: 栈的数组实现
 * @author: zhuzz
 * @date: 2018-09-11 12:19
 */
public class StackDemo<T> {

    private Object[] object;

    private int capicity;

    private int size;

    private final static int DEFAULT_CAPICAL = 10;

    public StackDemo() {
        capicity = DEFAULT_CAPICAL;
        object = new Object[capicity];
    }

    public StackDemo(int capicity) {
        this.capicity = capicity;
        object = new Object[this.capicity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T t) {
        if (size == capicity) {
            throw new IndexOutOfBoundsException("queue is full");
        }
        object[size++] = t;
    }

    /**
     * 修改移除元素的代码
     */
    public void remove() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("queue is empty");
        }
        object[--size] = null;
    }

    public void clear() {
        Arrays.fill(object, null);
        size = 0;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(object[i].toString());
        }
    }
}
