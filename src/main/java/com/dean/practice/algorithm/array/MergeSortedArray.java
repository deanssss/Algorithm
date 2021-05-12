package com.dean.practice.algorithm.array;

import java.util.Arrays;

/*
 * https://leetcode-cn.com/leetbook/read/all-about-array/x9lhe7/
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,5,6,0,0,0};
        int[] nums2 = new int[]{1,2,3};

        merge(nums1, nums1.length - nums2.length, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1, i = m - 1, j = n - 1;

        // 双指针法，从两个数组的尾部开始比较，值大的数据放到num1尾部，移动对应的指针，直到某一个数组处理完毕。
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[p--] = nums1[i--];
            } else {
                nums1[p--] = nums2[j--];
            }
        }

        // 如果数组1中还剩下数据，那么一定是已经排序好的，因此无需处理。
        // 如果数组2中还剩下数据，那么数组1部分已经排序好了，
        // 因此剩下位置的数据都是无效的，可以直接覆盖。
        while (j >= 0) {
            nums1[p--] = nums2[j--];
        }
    }
}
