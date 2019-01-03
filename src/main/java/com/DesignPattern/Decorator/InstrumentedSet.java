package com.DesignPattern.Decorator;

import java.util.Collection;
import java.util.Set;

/**
 * @description: 装饰模型
 * @author: zhuzz
 * @date: 2019/1/3 16:07
 */
public class InstrumentedSet<E> extends ForwardingSet<E> {
    private int addCount = 0;

    public InstrumentedSet(Set<E> s) {
        super(s);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
