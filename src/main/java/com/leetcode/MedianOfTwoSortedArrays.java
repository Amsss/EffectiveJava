package com.leetcode;

/**
 * @description: 4、寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * @author: zhuzz
 * @date: 2019-07-29 15:16
 */
public class MedianOfTwoSortedArrays {

    /**
     * 寻找两个有序数组的中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result;
        int[] merge = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i >= nums1.length) {
                merge[k++] = nums2[j++];
            } else if (j >= nums2.length) {
                merge[k++] = nums1[i++];
            } else {
                if (nums1[i] <= nums2[j]) {
                    merge[k++] = nums1[i++];
                } else {
                    merge[k++] = nums2[j++];
                }
            }
        }
        // 奇数偶数判断
        if (merge.length % 2 == 0) {
            result = (merge[merge.length / 2] + merge[merge.length / 2 - 1]) / 2.0;
        } else {
            result = merge[merge.length / 2];
        }
        return result;
    }

    /**
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int median1 = Integer.MIN_VALUE;
        int median2 = 0;
        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return nums1.length == 0 ? nums2[0] : nums1[0];
        }
        if (nums1.length == 0 && length > 1) {
            median1 = nums2[(length - 1) / 2];
            median2 = nums2[(length + 1) / 2];
        } else if (nums2.length == 0 && length > 1) {
            median1 = nums1[(length - 1) / 2];
            median2 = nums1[(length + 1) / 2];
        }
        for (int count = 0, i = 0, j = 0; count < (length + 1) / 2.0; count++) {
            if (nums1.length == 0 || nums2.length == 0) {
                break;
            }
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    median2 = median1;
                    median1 = nums1[i];
                    i++;
                } else {
                    median2 = median1;
                    median1 = nums2[j];
                    j++;
                }
            } else if (i >= nums1.length && j < nums2.length) {
                if (nums1[nums1.length - 1] > nums2[j]) {
                    median2 = median1;
                    median1 = nums1[nums1.length - 1];
                    i++;
                } else {
                    median2 = median1;
                    median1 = nums2[j];
                    j++;
                }
            } else if (i < nums1.length && j >= nums2.length) {
                if (nums1[i] < nums2[nums2.length - 1]) {
                    median2 = median1;
                    median1 = nums2[nums2.length - 1];
                    j++;
                } else {
                    median2 = median1;
                    median1 = nums1[i];
                    i++;
                }
            }
        }
        if ((length + 1) % 2 == 0) {
            return median1;
        } else {
            return (median1 + median2) / 2.0;
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    /**
     * i: nums1的起始位置 j: nums2的起始位置
     *
     * @param nums1
     * @param i
     * @param nums2
     * @param j
     * @param k
     * @return
     */
    public int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) {
            //nums1为空数组
            return nums2[j + k - 1];
        }
        if (j >= nums2.length) {
            //nums2为空数组
            return nums1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{4, 5, 6};
        long w = System.nanoTime();
        System.out.println(findMedianSortedArrays(a, b));
        long e = System.nanoTime();
        System.out.println(findMedianSortedArrays1(a, b));
        long r = System.nanoTime();
        System.out.println("我的:" + (e - w) / 1000000.0 + "网上的:" + (r - e) / 1000000.0);
    }
}
