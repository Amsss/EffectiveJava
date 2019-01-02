package com.Calculation;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018-12-29 16:26
 */
public class Kmp {

    /**
     * KMP算法
     *
     * @param str 匹配源
     * @param dest 匹配字符串
     * @param next next数组
     * @return 匹配字符串在源中的位置
     */
    public static int kmp(String str, String dest, int[] next) {
        for (int i = 0, j = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (str.charAt(i) == dest.charAt(j)) {
                j++;
            }
            if (j == dest.length()) {
                return i - j + 1;
            }
        }
        return 0;
    }

    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(j) != dest.charAt(i)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        String s = "aaabaaabaaabaaaab";
        String t = "aaaab";
        Long start1 = System.nanoTime();
        BruteForce.BFIndex(s, t);
        Long end1 = System.nanoTime();
        System.out.println("BF算法所需时间：" + (end1 - start1) + "ns");
        Long start2 = System.nanoTime();
        System.out.println("=====计算部分匹配表数组");
        int[] next = kmpNext(t);
        for (int i = 0; i < next.length; i++) {
            System.out.println(next[i]);
        }
        System.out.println("=====start");
        int res = kmp(s, t, next);
        System.out.println("匹配字符串位的开始位置:" + res);
        System.out.println("=====end");
        Long end2 = System.nanoTime();
        System.out.println("KMP算法所需时间：" + (end2 - start2) + "ns");
    }
}
