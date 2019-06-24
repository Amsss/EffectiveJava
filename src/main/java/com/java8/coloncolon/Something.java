package com.java8.coloncolon;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-02-28 10:07
 */
public class Something {
    // constructor methods
    Something() {
    }

    Something(String something) {
        System.out.println(something);
    }

    // static methods
    static String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }

    // object methods
    String endWith(String s) {
        return String.valueOf(s.charAt(s.length() - 1));
    }

    void endWith() {
    }
}
