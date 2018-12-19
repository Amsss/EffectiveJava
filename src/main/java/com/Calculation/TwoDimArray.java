package com.Calculation;

/**
 * @description: 多维矩阵转一维矩阵
 * @author: zhuzz
 * @date: 2018-09-12 16:24
 */
public class TwoDimArray {
    public static int[] toOneDimByRow(int[][] array) {
        int[] arr = new int[array.length * array[0].length];
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[0].length; column++) {
                int i = column + row * array[0].length;
                arr[i] = array[row][column];
            }
        }
        return arr;
    }

    public static int[] toOneDimByColumn(int[][] array) {
        int[] arr = new int[array.length * array[0].length];
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[0].length; column++) {
                int i = i = row + column * array.length;
                arr[i] = array[row][column];
            }
        }
        return arr;
    }

}
