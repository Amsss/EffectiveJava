package com.Calculation;

import java.util.Scanner;

/**
 * @description: 杨辉三角
 * @author: zhuzz
 * @date: 2018-09-12 10:35
 */
public class YangHuiSanJiao {
    public static void test1() {
        int[][] a = new int[10][10];
        for (int n = 0; n < 10; n++) {
            a[n][0] = 1;
            a[n][n] = 1;
        }
        for (int n = 2; n < 10; n++) {
            for (int j = 1; j < n; j++) {
                a[n][j] = a[n - 1][j - 1] + a[n - 1][j];
            }
        }

        for (int n = 0; n < 10; n++) {
            for (int k = 0; k < 2 * (10 - n) - 1; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= n; j++) {
                System.out.print(a[n][j] + "   ");
            }
            System.out.println();
        }
    }

    static int fun(int n, int k) {
        //n,行，k:列
        if (k == 1 || n == k) {
            return 1;
        } else {
            return fun(n - 1, k - 1) + fun(n - 1, k);
        }
    }

    public static void test2() {
        int lines;
        System.out.println("请输入行数：");
        Scanner input = new Scanner(System.in);
        lines = input.nextInt();
        for (int i = 1; i <= lines; i++) {
            for (int k = 1; k < lines - i + 1; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(fun(i, j) + " ");
            }
            System.out.println();
        }
    }

    public static void printYFTriangle() {
        System.out.println("杨辉三角，您准备输出的行数:");
        Scanner input = new Scanner(System.in);
        //获得循环的行数
        int lines = input.nextInt();
        // 临时存储数据用
        int[] a = new int[lines + 1];
        // 默认第一个数
        int previous = 1;
        //i 用来控制行数
        for (int i = 1; i <= lines; i++) {
            for (int j = 1; j <= lines - i; j++) {
                // 输出空格，很easy;
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                int current = a[j];
                // 先获得后一个数，
                a[j] = previous + current;
                previous = current;
                System.out.print(a[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printYFTriangle();
    }
}
