package com.guava;

import com.google.common.base.Joiner;

import java.util.Arrays;

/**
 * @description: Joiner 提供了各种方法来处理字符串加入操作，对象等
 * @author: zhuzz
 * @date: 2018-09-28 15:52
 */
public class GuavaJoinerTest {
    public static void main(String args[]) {
        String[] string = "".split(",");
        System.out.println(string);
        GuavaJoinerTest tester = new GuavaJoinerTest();
        tester.testJoiner();
    }

    private void testJoiner() {
        System.out.println(Joiner.on(",")
                .skipNulls()
                .join(Arrays.asList(1, 2, 3, 4, 5, null, 6)));
    }
}
