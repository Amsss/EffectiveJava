package com.calculation;

import java.util.Scanner;

/**
 * @description:
 * @author: zhuzz
 * @date: 2018-12-20 15:04
 */
public class Program {
    public static Scanner sc = new Scanner(System.in);
    public static int count = 0;

    public static void main(String[] args) {
        SameNumber();
        UnSameNumber();
    }

    public static int SIGN(long A) {
        return A > 0 ? 1 : -1;
    }

    //两整数位数相同
    private static void SameNumber() {
        System.out.print("请输入两个大整数：\nX=");
        long X = sc.nextLong();
        System.out.print("Y=");
        long Y = sc.nextLong();
        System.out.print("请输入两个大整数的长度：n=");
        int n = sc.nextInt();

        long sum = CalculateSame(X, Y, n);

        System.out.println("普通乘法 X*Y=" + X + "*" + Y + "=" + X * Y + "\n");
        System.out.println("分治乘法 X*Y=" + X + "*" + Y + "=" + sum + "\n");
    }

    public static long CalculateSame(long X, long Y, int n) {
        int sign = SIGN(X) * SIGN(Y);

        X = Math.abs(X);
        Y = Math.abs(Y);
        if (X == 0 || Y == 0) {
            return 0;
        } else if (n == 1) {
            return sign * X * Y;
        } else {
            long A = (long) (X / Math.pow(10, n / 2));
            long B = (long) (X % Math.pow(10, n / 2));
            long C = (long) (Y / Math.pow(10, n / 2));
            long D = (long) (Y % Math.pow(10, n / 2));

            long AC = CalculateSame(A, C, n / 2);
            long BD = CalculateSame(B, D, n / 2);
            long ABCD = CalculateSame((A - B), (D - C), n / 2) + AC + BD;

            return (long) (sign * (AC * Math.pow(10, n) + ABCD * Math.pow(10, n / 2) + BD));
        }
    }

    //两整数位数不同
    private static void UnSameNumber() {
        System.out.print("请输入两个大整数：\nX=");
        long X = sc.nextLong();
        System.out.print("Y=");
        long Y = sc.nextLong();
        System.out.print("请输入X的长度：xn=");
        int xn = sc.nextInt();
        System.out.print("请输入Y的长度：yn=");
        int yn = sc.nextInt();

        long sum = CalculateUnSame(X, Y, xn, yn);

        System.out.println("普通乘法 X*Y=" + X + "*" + Y + "=" + X * Y + "\n");
        System.out.println("分治乘法 X*Y=" + X + "*" + Y + "=" + sum + "\n");
    }

    public static long CalculateUnSame(long X, long Y, int xn, int yn) {
        if (X == 0 || Y == 0) {
            return 0;
        } else if ((xn == 1 && yn == 1) || xn == 1 || yn == 1) {
            return X * Y;
        } else {
            int xn0 = xn / 2, yn0 = yn / 2;
            int xn1 = xn - xn0, yn1 = yn - yn0;

            long A = (long) (X / Math.pow(10, xn0));
            long B = (long) (X % Math.pow(10, xn0));
            long C = (long) (Y / Math.pow(10, yn0));
            long D = (long) (Y % Math.pow(10, yn0));

            long AC = CalculateUnSame(A, C, xn1, yn1);
            long BD = CalculateUnSame(B, D, xn0, yn0);
            long ABCD = CalculateUnSame((long) (A * Math.pow(10, xn0) - B), (long) (D - C * Math.pow(10, yn0)), xn1, yn1);

            return (long) (2 * AC * Math.pow(10, (xn0 + yn0)) + ABCD + 2 * BD);
        }
    }
}
