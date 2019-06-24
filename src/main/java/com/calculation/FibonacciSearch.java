package com.calculation;

/**
 * @description: 费式查找法
 * @author: zhuzz
 * @date: 2018-09-12 16:22
 */
public class FibonacciSearch {
    public static int search(int[] number, int des) {
        int[] fib = createFibonacci(number.length);
        int x = findX(fib, number.length + 1, des);
        int m = number.length - fib[x];
        x--;
        int i = x;
        if (number[i] < des) {
            i += m;
        }
        while (fib[x] > 0) {
            if (number[i] < des) {
                i += fib[--x];
            } else if (number[i] > des) {
                i -= fib[--x];
            } else {
                return i;
            }
        }
        return -1;
    }

    private static int[] createFibonacci(int max) {
        int[] fib = new int[max];
        for (int i = 0; i < fib.length; i++) {
            fib[i] = Integer.MIN_VALUE;
        }
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < max; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    private static int findX(int[] fib, int n, int des) {
        int i = 0;
        while (fib[i] <= n) {
            i++;
        }
        i--;
        return i;
    }

    public static void main(String[] args) {
        int[] number = {
                1, 4, 2, 6, 7, 3, 9, 8
        };
        QuickSort.sort(number);
        int find = FibonacciSearch.search(number, 3);
        if (find != -1) {
            System.out.println("找到数值于索引" + find);
        } else {
            System.out.println("找不到数值");
        }
    }

}
