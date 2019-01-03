package com.designpattern.Iterator;

public class MyIterator implements Iterator {

    private Collection collection;
    private int pos = -1;

    public MyIterator(Collection collection) {
        this.collection = collection;
    }

    public Object previous() {
        if (pos > 0) {
            pos--;
        }
        return collection.get(pos);
    }

    public Object next() {
        if (pos < collection.size() - 1) {
            pos++;
        }
        return collection.get(pos);
    }

    public boolean hasNext() {
        return pos < (collection.size() - 1);
    }

    public Object first() {
        pos = 0;
        return collection.get(pos);
    }

}
