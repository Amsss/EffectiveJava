package com.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description: 字符串工具类
 * @author: zhuzz
 * @date: 2018-11-16 16:04
 */
public class StringUtil {
    private StringUtil() {
    }

    public static void main(String[] args) {
        Set<String> aa = new HashSet<>(16);
        List<String> list = new ArrayList<>(16);
        aa.add("1111");
        aa.add("xxxxxxxxxxxxx");
        list.addAll(aa);
        System.out.println(list);
    }
}
