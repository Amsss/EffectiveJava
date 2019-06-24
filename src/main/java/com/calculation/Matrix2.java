package com.calculation;

/**
 * @description: 4N魔方阵
 * @author: zhuzz
 * @date: 2018-09-12 16:25
 */
public class Matrix2 {
    public static int[][] magicFourN(int n) {
        int[][] square = new int[n + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= n; i++) {
                if (j % 4 == i % 4 || (j % 4 + i % 4) == 1) {
                    square[i][j] = (n + 1 - i) * n - j + 1;
                } else {
                    square[i][j] = (i - 1) * n + j;
                }
            }
        }
        int[][] matrix = new int[n][n];
        for (int k = 0; k < matrix.length; k++) {
            for (int l = 0; l < matrix[0].length; l++) {
                matrix[k][l] = square[k + 1][l + 1];
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] magic = Matrix2.magicFourN(8);
        for (int k = 0; k < magic.length; k++) {
            for (int l = 0; l < magic[0].length; l++) {
                System.out.print(magic[k][l] + " ");
            }
            System.out.println();
        }
    }
}
