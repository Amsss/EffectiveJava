package com.designpattern.interpreter;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:37
 */
public class Test {

    public static void main(String[] args) {
        // 计算9+2-8的值  
        int result = new Minus().interpret(new Context(new Plus()
                .interpret(new Context(9, 2)), 8));
        System.out.println(result);
    }
}
