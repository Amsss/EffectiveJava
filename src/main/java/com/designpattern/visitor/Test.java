package com.designpattern.visitor;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:59
 */
public class Test {
    public static void main(String[] args) {
        Visitor visitor = new MyVisitor();
        Subject sub = new MySubject();
        sub.accept(visitor);
    }
}
