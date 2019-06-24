package com.designpattern.interpreter;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:36
 */
public class Minus implements Expression {

    @Override
    public int interpret(Context context) {
        return context.getNum1() - context.getNum2();
    }
}
