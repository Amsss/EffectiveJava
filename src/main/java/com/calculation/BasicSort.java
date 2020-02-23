package com.calculation;

/**
 * @description: 选择排序、插入排序、气泡排序
 * @author: zhuzz
 * @date: 2018-09-12 16:06
 */
public class BasicSort {

    /**
     * 选择排序
     * 时间复杂度：
     * 是和数据的状况有关的算法流程，一律按照最差状况计算
     * 平均：有序序列：O(N^2)
     * 最差：逆序序列：O(N^2)
     * 所以时间复杂度为：O(N^2)
     *
     * @param number
     */
    private static void selectionSort(int[] number) {
        for (int i = 0; i < number.length - 1; i++) {
            int m = i;
            for (int j = i + 1; j < number.length; j++) {
                if (number[j] < number[m]) {
                    m = j;
                }
            }
            if (i != m) {
                swap(number, i, m);
            }
        }
    }

    /**
     * 插入排序
     * 时间复杂度：
     * 是和数据的状况有关的算法流程，一律按照最差状况计算
     * 最优：有序序列：O(N)
     * 最差：逆序序列：O(N^2)
     * 所以时间复杂度为：O(N^2)
     *
     * @param number
     */
    private static void injectionSort(int[] number) {
        for (int j = 1; j < number.length; j++) {
            int tmp = number[j];
            int i = j - 1;
            while (tmp < number[i]) {
                number[i + 1] = number[i];
                i--;
                if (i == -1) {
                    break;
                }
            }
            number[i + 1] = tmp;
        }
    }

    /**
     * 冒泡排序
     * 时间复杂度：O(N^2)
     *
     * @param number
     */
    private static void bubbleSort(int[] number) {
        boolean flag = true;
        for (int i = 0; i < number.length - 1 && flag; i++) {
            flag = false;
            for (int j = 0; j < number.length - i - 1; j++) {
                if (number[j + 1] < number[j]) {
                    swap(number, j + 1, j);
                    flag = true;
                }
            }
        }
    }

    private static void swap(int[] number, int i, int j) {
        int t;
        t = number[i];
        number[i] = number[j];
        number[j] = t;
    }

    public static void main(String[] args) {
        //测试：
        int[] a = {
                10, 9, 1, 100, 20, 200, 39, 45, 23, 18, 2, 2, 15
        };
        //测试选择排序：
        /*System.out.println("选择排序前：");
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
        int[] b;
        b = a;
        selectionSort(b);
        System.out.println("选择排序后：");
        for (int x : b) {
            System.out.print(x + " ");
        }
        System.out.println();*/
        //测试插入排序：
        System.out.println("插入排序前：");
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
        int[] c;
        c = a;
        injectionSort(c);
        System.out.println("插入排序后：");
        for (int x : c) {
            System.out.print(x + " ");
        }
        System.out.println();
        //测试气泡排序：
        System.out.println("气泡排序前：");
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
        int[] d;
        d = a;
        bubbleSort(d);
        System.out.println("气泡排序后：");
        for (int x : d) {
            System.out.print(x + " ");
        }
    }

}
