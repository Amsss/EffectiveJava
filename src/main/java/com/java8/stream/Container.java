package com.java8.stream;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-02-26 17:24
 */
public class Container {
    // 定义本地的result
    public Set<Double> set;

    public Container() {
        this.set = new HashSet<>();
    }

    public Container accumulate(int num) {
        this.set.add(Compute.compute(num));
        return this;
    }

    public Container combine(Container container) {
        this.set.addAll(container.set);
        return this;
    }

    public Set<Double> getResult() {
        return this.set;
    }
}
