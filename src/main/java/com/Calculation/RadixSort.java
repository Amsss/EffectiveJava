package com.Calculation;

/**
 * @description: 基数排序
 * @author: zhuzz
 * @date: 2018-09-12 16:19
 */
public class RadixSort {
    public static void sort(int[] number, int d) {
        int k = 0;
        int n = 1;
        int[][] temp = new int[number.length][number.length];
        int[] order = new int[number.length];
        while (n <= d) {
            for (int i = 0; i < number.length; i++) {
                int lsd = ((number[i] / n) % 10);
                temp[lsd][order[lsd]] = number[i];
                order[lsd]++;
            }
            for (int i = 0; i < number.length; i++) {
                if (order[i] != 0) {
                    for (int j = 0; j < order[i]; j++) {
                        number[k] = temp[i][j];
                        k++;
                    }
                }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
        }
    }
    public static void main(String[] args) {
        int[] data = {
                73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33, 100
        };
        RadixSort.sort(data, 100);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

}
