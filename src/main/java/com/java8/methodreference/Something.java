package com.java8.methodreference;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-02-28 10:07
 */
public class Something {
    Something() {
    }

    Something(String something) {
        System.out.println(something);
    }

    static String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }

    String endWith(String s) {
        return String.valueOf(s.charAt(s.length() - 1));
    }

    void endWith() {
    }
}
