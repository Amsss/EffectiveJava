package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @description: 3、
 * @author: zhuzz
 * @date: 2019-05-21 19:33
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        Long start1 = System.nanoTime();
        System.out.println(lengthOfLongestSubstringMe("dvdf"));
        Long start2 = System.nanoTime();
        System.out.println(lengthOfLongestSubstringOther("dvdf"));
        Long start3 = System.nanoTime();
        System.out.println(lengthOfLongestSubstringBest("dvdf"));
        Long start4 = System.nanoTime();
        System.out.println((start2 - start1)/1000);
        System.out.println((start3 - start2)/1000);
        System.out.println((start4 - start3)/1000);
    }

    /**
     * 2ms
     *
     * @param s
     * @return
     */
    private static int lengthOfLongestSubstringOther(String s) {
        int[] map = new int[256];
        int j = 0, max = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && count == 0) {
                if (map[s.charAt(j++)]++ > 0) {
                    count++;
                }
                if (count == 0 && j - i > max) {
                    max = j - i;
                }
            }
            if (--map[s.charAt(i)] == 1) {
                count--;
            }
        }
        return max;
    }

    /**
     * 1ms
     *
     * @param s
     * @return
     */
    private static int lengthOfLongestSubstringBest(String s) {
        char[] array = s.toCharArray();
        s = null;
        int start = 0;
        int maxLen = 0;
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return 1;
        }
        for (int cursor = 1; cursor < array.length; cursor++) {
            for (int i = start; i < cursor; i++) {
                if (array[i] == array[cursor]) {
                    maxLen = maxLen < (cursor - start) ? cursor - start : maxLen;
                    start = i + 1;
                    break;
                }
            }
        }
        return maxLen < (array.length - start) ? array.length - start : maxLen;
    }

    /**
     * 58 ms
     *
     * @param s
     * @return
     */
    private static int lengthOfLongestSubstringMe(String s) {
        List<Integer> nums = new ArrayList<>();
        HashSet hashSet = new HashSet<Character>();
        int i = 0, j = 0;
        while (j < s.length()) {
            //i = j;
            char value = s.charAt(i);
            if (hashSet.contains(value)) {
                nums.add(hashSet.size());
                hashSet.clear();
                i = ++j;
            } else {
                hashSet.add(value);
                i++;
            }
            if (i == s.length()) {
                break;
            }
        }
        nums.add(hashSet.size());
        return Collections.max(nums).intValue();
    }
}
