package com.designpattern.iterator;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:39
 */
public class MyCollection implements Collection {

    public String string[] = {"A", "B", "C", "D", "E"};

    @Override
    public Iterator iterator() {
        return new MyIterator(this);
    }

    @Override
    public Object get(int i) {
        return string[i];
    }

    @Override
    public int size() {
        return string.length;
    }
}
