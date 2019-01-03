package com.calculation;

/**
 * @description: 判断是否阿姆斯壮数
 * @author: zhuzz
 * @date: 2018-09-12 12:11
 */
public class Armstrong {
    public static void main(String[] args) {
        int c = 0, a, temp;
        // It is the number to check armstrong
        int n = 123;
        temp = n;
        while (n > 0) {
            a = n % 10;
            n = n / 10;
            c = c + (a * a * a);
        }
        if (temp == c) {
            System.out.println("armstrong number");
        } else {
            System.out.println("Not armstrong number");
        }
    }

    public static void search() {
        System.out.println("寻找Armstrong数：");
        for (int i = 100; i <= 999; i++) {
            int a = i / 100;
            int b = (i % 100) / 10;
            int c = i % 10;
            if (a * a * a + b * b * b + c * c * c == i) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

    }
}
