package com.DesignPattern.Decorator;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/3 16:10
 */
public class Source implements Sourceable {  
	  
    @Override
    public void method() {
        System.out.println("the original method!");  
    }  
}
