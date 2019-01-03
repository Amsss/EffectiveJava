package com.calculation;

/**
 * @description: 上三角、下三角、对称矩阵
 * @author: zhuzz
 * @date: 2018-09-12 16:24
 */
public class TriangleArray {
    private int[] arr;
    private int length;
    public TriangleArray(int[][] array) {
        length = array.length;
        arr = new int[length * (1 + length) / 2];
        int loc = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (array[i][j] != 0) {
                    arr[loc++] = array[i][j];
                }
            }
        }
    }
    public int getValue(int i, int j) {
        int loc = length * i - i * (i + 1) / 2 + j;
        return arr[loc];
    }
    public static void main(String[] args) {
        int[][] array = {
                {
                        1, 2, 3, 4, 5
                }, {
                0, 6, 7, 8, 9
        }, {
                0, 0, 10, 11, 12
        }, {
                0, 0, 0, 13, 14
        }, {
                0, 0, 0, 0, 15
        }
        };
        TriangleArray triangleArray = new TriangleArray(array);
        System.out.print(triangleArray.getValue(2, 2));
    }
}
