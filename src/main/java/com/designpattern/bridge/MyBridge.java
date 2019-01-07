package com.designpattern.bridge;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:25
 */
public class MyBridge extends Bridge {  
    @Override
    public void method(){
        getSource().method();  
    }  
}
