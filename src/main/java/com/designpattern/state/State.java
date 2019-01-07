package com.designpattern.state;

/**
 * @description: 状态类的核心类
 * @author: zhuzz
 * @date: 2019/1/7 11:56
 */
public class State {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void method1() {
        System.out.println("execute the first opt!");
    }

    public void method2() {
        System.out.println("execute the second opt!");
    }
}
