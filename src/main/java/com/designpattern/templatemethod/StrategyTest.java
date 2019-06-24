package com.designpattern.templatemethod;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:58
 */
public class StrategyTest {

    public static void main(String[] args) {
        String exp = "8+8";
        AbstractCalculator cal = new Plus();
        int result = cal.calculate(exp, "\\+");
        System.out.println(result);
    }
}
