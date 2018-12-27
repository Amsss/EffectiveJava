package com.Calculation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: 得分排行 ----假设有一教师依学生座号输入考试分数，现希望在输入完毕后自动显示学生分数的排行，当然学生的分数可能相同
 * @author: zhuzz
 * @date: 2018-09-12 16:04
 */
public class ScoreRank {
    public static void main(String[] args) throws NumberFormatException, IOException {
        final int MAX = 100;
        final int MIN = 0;
        int[] score = new int[MAX + 1];
        int[] juni = new int[MAX + 2];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        do {
            System.out.print("输入分数，-1结束：");
            score[count++] = Integer.parseInt(reader.readLine());
        } while ((score[count - 1] != -1));
        count--;
        for (int i = 0; i < count; i++) {
            juni[score[i]]++;
        }
        juni[MAX + 1] = 1;
        for (int i = MAX; i >= MIN; i--) {
            juni[i] = juni[i] + juni[i + 1];
        }
        System.out.println("得分\t排行");
        for (int i = 0; i < count; i++) {
            System.out.println(score[i] + "\t" + juni[score[i] + 1]);
        }
    }
}
