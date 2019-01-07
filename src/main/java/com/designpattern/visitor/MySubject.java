package com.designpattern.visitor;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:58
 */
public class MySubject implements Subject {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getSubject() {
        return "love";
    }
}