package com.designpattern.bridge;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:25
 */
public class SourceSub1 implements Sourceable {

    @Override
    public void method() {
        System.out.println("this is the first sub!");
    }
}
