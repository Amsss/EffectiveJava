package com.calculation;

/**
 * @description: 希尔排序
 * @author: zhuzz
 * @date: 2018-09-12 16:29
 */
public class ShellSort {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ShellSort ss = new ShellSort();
        int num[] = {
                546, 87, 21, 3124, 65, 2, 9, 3, 213, 54, 98, 23, 6, 4, 7,
                8, 123, 872, 61, 5, 8954
        };
        ss.shellArray(num);
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }

    public void shellArray(int[] num) {
        int i = 1;
        int tem, in;
        for (; i < num.length / 3; ) {
            i = 3 * i + 1;
        }
        for (; i >= 1; ) {
            for (int j = i; j < num.length; j++) {
                tem = num[j];
                in = j;
                while (in > i - 1 && num[in - i] >= tem) {
                    num[in] = num[in - i];
                    in = in - i;
                }
                num[in] = tem;
            }
            i = (i - 1) / 3;
        }
    }
}
