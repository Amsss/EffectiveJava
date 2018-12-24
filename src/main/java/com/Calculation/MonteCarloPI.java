package com.Calculation;

/**
 * @description: 蒙地卡罗法求PI
 * @author: zhuzz
 * @date: 2018-09-12 11:03
 */
public class MonteCarloPI {
    public static void main(String[] args) {
        final int N = 50000000;
        int sum = 0;
        for (int i = 1; i < N; i++) {
            double x = Math.random();
            double y = Math.random();
            if ((x * x + y * y) < 1) {
                sum++;
            }
        }
        System.out.println("PI = " + (double) 4 * sum / N);
    }
}
