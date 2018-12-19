package com.Calculation;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018-09-12 16:14
 */
public class QuickSort2 {

    public static void sort(int[] number) {
        sort(number, 0, number.length - 1);
    }
    private static void sort(int[] number, int left, int right) {
        if (left < right) {
            int s = number[(left + right) / 2];
            int i = left - 1;
            int j = right + 1;
            while (true) {
                // 向右找
                while (number[++i] < s) {
                }
                // 向左找
                while (number[--j] > s) {
                }
                if (i >= j) {
                    break;
                }
                swap(number, i, j);
            }
            sort(number, left, i - 1);
            // 对左边进行递回
            sort(number, j + 1, right);
            // 对右边进行递回
        }
    }
    private static void swap(int[] number, int i, int j) {
        int t;
        t = number[i];
        number[i] = number[j];
        number[j] = t;
    }

}
