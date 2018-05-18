package com.DesignPattern.Interpreter;

public class Minus implements Expression {  
	  
    public int interpret(Context context) {
        return context.getNum1()-context.getNum2();  
    }  
}
