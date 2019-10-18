package com.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: Joiner 提供了各种方法来处理字符串加入操作，对象等
 * @author: zhuzz
 * @date: 2018-09-28 15:52
 */
public class GuavaJoinerTest {
    public static void main(String args[]) {
        System.out.println(Joiner.on(",")
                .skipNulls()
                .join(Arrays.asList(new StringBuffer("222"), "3", "4", "4", "3", "2", null, "", "", "").stream().filter(s -> s != null && !Strings.isNullOrEmpty(s.toString())).collect(Collectors.toList()))
        );
        String[] string = "".split(",");
        System.out.println(string);
        GuavaJoinerTest tester = new GuavaJoinerTest();
        tester.testJoiner();
    }

    private void testJoiner() {
        List<String> list = new ArrayList<>(2);
        System.out.println(Joiner.on(",")
                .skipNulls()
                .join(Arrays.asList(1, 2, 3, 4, 5, 6, null, "", "", "")));
        System.out.println(Joiner.on(",")
                .skipNulls()
                .join(list));
        String XX = Joiner.on(",")
                .skipNulls()
                .join(list);
        System.out.println(XX);
    }
}
