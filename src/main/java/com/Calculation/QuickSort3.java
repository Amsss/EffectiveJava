package com.Calculation;

/**
 * @Description: 快速排序（三）
 * @author: zhuzz
 * @date: 2018-09-12 16:14
 */
public class QuickSort3 {
    public static void sort(int[] number) {
        sort(number, 0, number.length - 1);
    }
    private static void sort(int[] number, int left, int right) {
        if (left < right) {
            int q = partition(number, left, right);
            sort(number, left, q - 1);
            sort(number, q + 1, right);
        }
    }
    private static int partition(int number[], int left, int right) {
        int s = number[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (number[j] <= s) {
                i++;
                swap(number, i, j);
            }
        }
        swap(number, i + 1, right);
        return i + 1;
    }
    private static void swap(int[] number, int i, int j) {
        int t;
        t = number[i];
        number[i] = number[j];
        number[j] = t;
    }
}
