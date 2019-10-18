package com.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: zhuzz
 * @date: 2019-04-26 9:35
 */
public class Test {
    public static void main(String[] args) {
        List<String> AA = new ArrayList<>(16);
        String[] bb = new String[]{"1", "2", "C", "B", "A"};
        AA.add("B");
        AA.add("C");
        AA.add("A");
        System.out.println(bb);
        Arrays.sort(bb);
        System.out.println(bb);
        System.out.println(AA);
        Collections.sort(AA);
        System.out.println(AA);
    }
}
