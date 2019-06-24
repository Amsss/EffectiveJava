package com.designpattern.visitor;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:59
 */
public interface Visitor {
    /**
     *
     * @param sub
     */
    void visit(Subject sub);
}
