package com.Calculation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description: 最大访客数--先计算某时之前总共来访了多少访客，然后再减去某时之前的离开访客
 * @author: zhuzz
 * @date: 2018-09-12 12:23
 */
public class AlgorithmGossip {

    public static int maxGuest(int[] x, int[] y, int time) {
        int num = 0;
        for (int i = 0; i < x.length; i++) {
            if (time > x[i]) {
                num++;
            }
            if (time > y[i]) {
                num--;
            }
        }
        return num;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入来访时间与离开时间(0~24)：");
        System.out.println("范例：10 15");
        System.out.println("输入-1结束");
        java.util.ArrayList list = new ArrayList();
        while (true) {
            System.out.print(">>");
            String input = buf.readLine();
            if (input.equals("-1")){
                break;
            }
            list.add(input);
        }
        int[] x = new int[list.size()];
        int[] y = new int[list.size()];
        for (int i = 0; i < x.length; i++) {
            String input = (String) list.get(i);
            String[] strs = input.split(" ");
            x[i] = Integer.parseInt(strs[0]);
            y[i] = Integer.parseInt(strs[1]);
        }
        Arrays.sort(x);
        Arrays.sort(y);
        for (int time = 0; time < 25; time++) {
            System.out.println(time + " 时的最大访客数：" + AlgorithmGossip.maxGuest(x, y, time));
        }
    }
}
