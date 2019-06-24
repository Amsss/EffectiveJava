package com.designpattern.strategy;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:57
 */
public class Minus extends AbstractCalculator implements ICalculator {

    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp, "-");
        return arrayInt[0] - arrayInt[1];
    }

}
