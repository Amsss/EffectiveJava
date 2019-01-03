package com.calculation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @description: 求最大公约数和最小公倍数
 * @author: zhuzz
 * @date: 2018-09-12 12:06
 */
public class MaxCommonDivisorAndMinCommonMultiple {

    public static int gcdOf(int m, int n) {
        int r;
        while (n != 0) {
            r = m % n;
            m = n;
            n = r;
        }
        return m;
    }

    public static int lcmOf(int m, int n) {
        return m * n / gcdOf(m, n);
    }

    public static void main(String[] args) throws IOException {
        ///========================11111111111111111111111111
        BufferedReader ln = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入第一个数：");
        int x = Integer.parseInt(ln.readLine());
        System.out.print("请输入第二个数：");
        int y = Integer.parseInt(ln.readLine());
        System.out.println("GCD of (" + x + "," + y + ")=" + MaxCommonDivisorAndMinCommonMultiple.gcdOf(x, y));
        System.out.println("LCM of (" + x + "," + y + ")=" + MaxCommonDivisorAndMinCommonMultiple.lcmOf(x, y));
        ///========================2222222222222222222222222222222
        // 接收控制台输入的信息
        Scanner scan = new Scanner(System.in);

        System.out.print("请输入第一个整数：");
        // 取出控制台输入的信息
        int num1 = scan.nextInt();

        System.out.print("请输入第二个整数：");
        // 取出控制台输入的信息
        int num2 = scan.nextInt();
        // 调用maxCommonDivisor()方法
        System.out.println(maxCommonDivisor(num1, num2));
        // 调用minCommonMultiple()方法
        System.out.println(minCommonMultiple(num1, num2));
    }

    // 递归法求最大公约数
    public static int maxCommonDivisor(int m, int n) {
        // 保证m>n,若m<n,则进行数据交换
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        // 若余数为0,返回最大公约数
        if (m % n == 0) {
            return n;
            // 否则,进行递归,把n赋给m,把余数赋给n
        } else {
            return maxCommonDivisor(n, m % n);
        }
    }

    // 循环法求最大公约数
    public static int maxCommonDivisor2(int m, int n) {
        // 保证m>n,若m<n,则进行数据交换
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        // 在余数不能为0时,进行循环
        while (m % n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        // 返回最大公约数
        return n;
    }

    // 求最小公倍数
    public static int minCommonMultiple(int m, int n) {
        return m * n / maxCommonDivisor(m, n);
    }
}
