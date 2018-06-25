package com.ClassLoading;

public class Father {
    public static int i = 3;

    static {
        System.out.println("Father static block");
    }
}
