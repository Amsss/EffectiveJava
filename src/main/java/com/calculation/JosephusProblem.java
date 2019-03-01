package com.calculation;

/**
 * @description: 约瑟夫问题
 * @author: zhuzz
 * @date: 2018-09-12 13:47
 */
public class JosephusProblem {
    public static int[] arrayOfJosephus(int number, int per) {
        int[] man = new int[number];
        for (int count = 1, i = 0, pos = -1; count <= number; count++) {
            do {
                // 环状处理
                pos = (pos + 1) % number;
                if (man[pos] == 0) {
                    i++;
                }
                // 报数为3了
                if (i == per) {
                    i = 0;
                    break;
                }
            } while (true);
            man[pos] = count;
        }
        return man;
    }

    public static void main(String[] args) {
        int[] man = JosephusProblem.arrayOfJosephus(41, 3);
        int alive = 3;
        System.out.println("约琴夫排列：");
        for (int i = 0; i < 41; i++) {
            System.out.print(man[i] + " ");
        }
        System.out.println("\nL表示3个存活的人要放的位置：");
        for (int i = 0; i < 41; i++) {
            if (man[i] > (41 - alive)) {
                System.out.print("L");
            } else {
                System.out.print("D");
            }
            if ((i + 1) % 5 == 0) {
                System.out.print("  ");
            }
        }
        System.out.println();
    }

}
