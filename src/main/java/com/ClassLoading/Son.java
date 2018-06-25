package com.ClassLoading;

import com.ClassLoading.Father;

public class Son extends Father {
    static {
        System.out.println("Father static block");
    }
}
