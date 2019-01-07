package com.designpattern.proxy;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:53
 */
public class ProxyTest {

    public static void main(String[] args) {
        Sourceable source = new Proxy();
        source.method();
    }
}
