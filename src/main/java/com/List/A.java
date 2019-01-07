package com.List;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 测试list为final的情况下对for each 循环的影响
 * @author: zhuzz
 * @date: 2018-06-12 14:50
 */
public class A {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        for (final String b : list) {
            System.out.println(b);
        }
    }
}
