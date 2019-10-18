package com.jvm.classloader;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-07-22 16:50
 */
public class ClassWillBeLoaded {
    public static void main(String[] args) {
        ClassWillBeLoaded obj = new ClassWillBeLoaded();
    }

    public String doTask(String str1, String str2) {
        return str1 + "ZHUZZZZZZZZZZZZZ" + str2;
    }
}
