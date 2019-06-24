package com.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 校验是否为中文
 * @author: zhuzz
 * @date: 2018/12/17 15:23
 */
public class CheckUtil {

    private CheckUtil() {

    }

    private static Pattern STRING_PATTERN = Pattern.compile("[\u4e00-\u9fa5]");

    /**
     * 判断字符串中是否包含中文（不能校验是否为中文标点符号）
     *
     * @param str 待校验字符串
     * @return 是否为中文
     */
    public static boolean isContainChinese(String str) {
        Matcher m = STRING_PATTERN.matcher(str);
        return m.find();
    }

    public static void main(String[] args) {
        String aa = "aaa";
        System.out.println(isContainChinese(aa));
    }
}
