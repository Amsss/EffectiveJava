package com.designpattern.adapter.three;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:19
 */
public class SourceSub2 extends AbstractWrapper2 {
    @Override
    public void method2() {
        System.out.println("the sourceable interface's second Sub2!");
    }
}
