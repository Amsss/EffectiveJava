package com.designpattern.adapter.three;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:18
 */
public class SourceSub1 extends AbstractWrapper2 {
    @Override
    public void method1() {
        System.out.println("the sourceable interface's first Sub1!");
    }
}
