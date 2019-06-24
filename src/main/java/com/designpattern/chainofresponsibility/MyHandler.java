package com.designpattern.chainofresponsibility;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018/10/9 13:58
 */
public class MyHandler extends AbstractHandler implements Handler {

    private String name;

    public MyHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.out.println(name + "deal!");
        if (getHandler() != null) {
            getHandler().operator();
        }
    }
}
