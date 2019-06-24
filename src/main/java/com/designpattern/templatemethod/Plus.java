package com.designpattern.templatemethod;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:58
 */
public class Plus extends AbstractCalculator {

    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
} 
