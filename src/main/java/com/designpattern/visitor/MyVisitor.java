package com.designpattern.visitor;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:58
 */
public class MyVisitor implements Visitor {

    @Override
    public void visit(Subject sub) {
        System.out.println("visit the subject：" + sub.getSubject());
    }
}
