package com.leetcode;

/**
 * @description: 6、Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * @author: zhuzz
 * @date: 2019-07-31 17:05
 */
public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        // 保留结果集
        int length = s.length();
        char[] result = new char[length];
        char[] a = s.toCharArray();
        int index = (numRows - 1) * 2;
        int bb = length / index;
/*        for () {

        }*/
                return result.toString();
    }

    public static void main(String[] args) {
        char[] result = new char[]{'1', '2'};
        System.out.println(result);
    }
}
