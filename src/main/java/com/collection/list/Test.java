package com.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 测试list为final的情况下对for each 循环的影响
 * @author: zhuzz
 * @date: 2018-06-12 14:50
 */
public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(4);
        list.add("a");
        list.add("b");
        list.add("c");
        for (final String b : list) {
            //循环过程中禁止修改 例如： b = "11";
            System.out.println(b);
        }
        list.forEach(System.out::println);
    }
}
