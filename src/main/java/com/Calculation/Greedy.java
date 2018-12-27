package com.Calculation;

import java.util.Stack;

/**
 * @description: 贪心算法
 * @author: zhuzz
 * @date: 2018-12-25 14:09
 */
public class Greedy {

    /**
     * 钱币找零问题
     *
     * @param money the money
     */
    public static void greedyGiveMoney(int money) {
        System.out.println("需要找零: " + money);
        int[] moneyLevel = {1, 5, 10, 20, 50, 100};
        for (int i = moneyLevel.length - 1; i >= 0; i--) {
            int num = money / moneyLevel[i];
            int mod = money % moneyLevel[i];
            money = mod;
            if (num > 0) {
                System.out.println("需要" + num + "张" + moneyLevel[i] + "块的");
            }
        }
        Stack<String> stack = new Stack<>();
    }

    public static void main(String[] args) {
        greedyGiveMoney(60);
    }
}
