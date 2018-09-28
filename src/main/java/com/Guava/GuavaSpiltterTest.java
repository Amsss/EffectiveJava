package com.Guava;

import com.google.common.base.Splitter;

/**
 * @Description: Splitter 提供了各种方法来处理分割操作字符串，对象等
 * @author: zhuzz
 * @date: 2018-09-28 15:53
 */
public class GuavaSpiltterTest {
    public static void main(String args[]) {
        GuavaSpiltterTest tester = new GuavaSpiltterTest();
        tester.testSplitter();
    }

    private void testSplitter() {
        System.out.println(Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("the ,quick, , brown         , fox,              jumps, over, the, lazy, little dog."));
    }
}
