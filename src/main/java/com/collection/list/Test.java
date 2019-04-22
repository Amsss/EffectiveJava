package com.collection.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description: 测试list为final的情况下对for each 循环的影响
 * @author: zhuzz
 * @date: 2018-06-12 14:50
 */
public class Test {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("20180101");
        set.add("20180106");
        set.add("20180103");
        set.add("20180104");
        set.add("20180105");
        System.out.println(set);
        Set<String> list2 = new HashSet<>(4);
        list2.add("111");
        System.out.println(list2.contains("111"));
        System.out.println(list2.contains("1111"));

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
