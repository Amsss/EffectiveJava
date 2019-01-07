package com.designpattern.facade;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019/1/7 11:33
 */
public class User {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }
} 
