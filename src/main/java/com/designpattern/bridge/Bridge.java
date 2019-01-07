package com.designpattern.bridge;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:25
 */
public abstract class Bridge {

    private Sourceable source;

    public void method() {
        source.method();
    }

    public Sourceable getSource() {
        return source;
    }

    public void setSource(Sourceable source) {
        this.source = source;
    }
}
