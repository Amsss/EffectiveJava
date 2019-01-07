package com.designpattern.strategy;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:57
 */
public class StrategyTest {
    public static void main(String[] args) {
        String exp = "2+8";
        ICalculator cal = new Plus();
        int result = cal.calculate(exp);
        System.out.println(result);
    }
}
