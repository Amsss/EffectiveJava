package com.calculation;

/**
 * @description: 排列组合
 * @author: zhuzz
 * @date: 2018-09-12 13:50
 */
public class PermutationAndCombination {
    public static void perm(int[] num, int i) {
        if (i < num.length - 1) {
            for (int j = i; j <= num.length - 1; j++) {
                int tmp = num[j];
                // 旋转该区段最右边数字至最左边
                System.arraycopy(num, i, num, i + 1, j - i);
                num[i] = tmp;
                perm(num, i + 1);
                // 还原
                System.arraycopy(num, i + 1, num, i, j - i);
                num[j] = tmp;
            }
        } else {
            // 显示此次排列
            for (int j = 1; j <= num.length - 1; j++) {
                System.out.print(num[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] mun1 = {
                1, 2, 3, 4, 5, 6, 7, 8, 9
        };
        int[] mun2 = {
                11, 22, 33, 44, 55, 66, 77, 88, 99
        };
        for (int j = 0; j < mun1.length ; j++) {
            System.out.print(mun1[j] + " ");
        }
        System.out.println();
        for (int j = 0; j < mun2.length ; j++) {
            System.out.print(mun2[j] + " ");
        }
        System.out.println();
        System.arraycopy(mun1, 0, mun2, 0, 1);
        for (int j = 0; j < mun1.length ; j++) {
            System.out.print(mun1[j] + " ");
        }
        System.out.println();
        mun1[1] = 20;
        for (int j = 0; j < mun2.length ; j++) {
            System.out.print(mun2[j] + " ");
        }
        System.out.println();
        /*int[] num = new int[4 + 1];
        for (int i = 1; i <= num.length - 1; i++) {
            num[i] = i;
        }
        perm(num, 1);*/
    }

}
