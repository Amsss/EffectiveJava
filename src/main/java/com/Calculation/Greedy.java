package com.Calculation;

import java.util.Stack;

/**
 * @description: 贪心算法
 * 适用场景
 * 1、单源最短路经问题
 * 2、最小生成树问题
 * 3、可任意分割的背包问题。如果不可以任意分割，就需要用动态规划求解。
 * 4、某些情况下，即使贪心算法不能得到整体最优解，其最终结果却是最优解的很好近似。
 * 5、活动安排（活动选择问题就是要选择出一个由互相兼容的问题组成的最大集合）
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
    }

    public static void main(String[] args) {
        greedyGiveMoney(60);
    }
}
