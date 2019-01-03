package com.calculation;

/**
 * @description: 稀疏矩阵
 * @author: zhuzz
 * @date: 2018-09-12 16:23
 */
public class SparseMatrix {
    public static int[][] restore(int[][] sparse) {
        int row = sparse[0][0];
        int column = sparse[0][1];
        int[][] array = new int[row][column];
        int k = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (k <= sparse[0][2] && i == sparse[k][0] && j == sparse[k][1]) {
                    array[i][j] = sparse[k][2];
                    k++;
                } else {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }
    public static void main(String[] args) {
        int[][] sparse = {
                {
                        5, 6, 4
                }, {
                1, 1, 3
        }, {
                2, 3, 6
        }, {
                3, 2, 9
        }, {
                4, 4, 12
        }
        };
        int[][] array = SparseMatrix.restore(sparse);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
