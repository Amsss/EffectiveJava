package com.Calculation;

/**
 * @Description: 2(2n+1)魔方阵
 * @author: zhuzz
 * @date: 2018-09-12 16:26
 */
public class Matrix3 {

    public static int[][] magic22mp1(int n) {
        int[][] square = new int[n][n];
        magic_o(square, n / 2);
        exchange(square, n);
        return square;
    }
    private static void magic_o(int[][] square, int n) {
        int row = 0;
        int column = n / 2;
        for (int count = 1; count <= n * n; count++) {
            square[row][column] = count;
            // 填A
            square[row + n][column + n] = count + n * n;
            // 填B
            square[row][column + n] = count + 2 * n * n;
            // 填C
            square[row + n][column] = count + 3 * n * n;
            // 填D
            if (count % n == 0) row++;
            else {
                row = (row == 0) ? n - 1 : row - 1;
                column = (column == n - 1) ? 0 : column + 1;
            }
        }
    }
    private static void exchange(int[][] x, int n) {
        int i, j;
        int m = n / 4;
        int m1 = m - 1;
        for (i = 0; i < n / 2; i++) {
            if (i != m) {
                for (j = 0; j < m; j++)
                    // 处理规则 1
                    swap(x, i, j, n / 2 + i, j);
                for (j = 0; j < m1; j++)
                    // 处理规则 2
                    swap(x, i, n - 1 - j, n / 2 + i, n - 1 - j);
            } else {
                // 处理规则 3
                for (j = 1; j <= m; j++) swap(x, m, j, n / 2 + m, j);
                for (j = 0; j < m1; j++) swap(x, m, n - 1 - j, n / 2 + m, n - 1 - j);
            }
        }
    }
    private static void swap(int[][] number, int i, int j, int k, int l) {
        int t;
        t = number[i][j];
        number[i][j] = number[k][l];
        number[k][l] = t;
    }
    public static void main(String[] args) {
        int[][] magic = Matrix3.magic22mp1(6);
        for (int k = 0; k < magic.length; k++) {
            for (int l = 0; l < magic[0].length; l++) {
                System.out.print(magic[k][l] + " ");
            }
            System.out.println();
        }
    }
}
