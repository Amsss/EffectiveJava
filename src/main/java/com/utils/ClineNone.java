package com.utils;

/**
 * @description:
 * @author: zhuzz
 * @date: 2020-02-21 13:51
 */
public class ClineNone {

    //求出来的b值
    public static double getB(double[] x, double[] y, int j) {
        //首先先保证xy是数量相同的
        double b = 0;
        //先对x求平均
        double xp = 0;
        double yp = 0;
        for (int i = 0; i < j; i++) {
            xp += x[i];
            yp += y[i];
        }
        xp = xp / (double) j;
        yp = yp / (double) j;
        //第二步
        // 计算一系列的差值 x-xp,y-yp
        double xpp = 0;
        double ypp = 0;
        double zpp = 0;
        double xxp = 0;
        for (int k = 0; k < j; k++) {
            xpp = (x[k] - xp);
            ypp = (y[k] - yp);
            zpp += (xpp * ypp);
            xxp += (xpp * xpp);
        }

        b = zpp / xxp;

        return b;
    }

    //测试
    public static void main(String[] args) {
        double[] x = {1, 2, 3, 4};
        double[] y = {12000, 13000, 13000, 13000};
        double f = getB(x, y, x.length);
        System.out.println(f + "---------------------------");
    }//
}
