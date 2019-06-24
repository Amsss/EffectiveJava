package com.calculation;

/**
 * @description: 回溯法
 * @author: zhuzz
 * @date: 2018-12-29 17:18
 */
public class BruteForce {

    public static int bFIndex(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == t.length()) {
            return i - j;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "aaabaaabaaabaaaab";
        String t = "aaaab";
        System.out.println(bFIndex(s, t));
    }
}
