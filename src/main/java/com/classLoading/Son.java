package com.classLoading;

public class Son extends Father {
    static {
        System.out.println("Father static block");
    }
}
