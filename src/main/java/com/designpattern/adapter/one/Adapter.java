package com.designpattern.adapter.one;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:15
 */
public class Adapter extends Source implements Targetable {

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
