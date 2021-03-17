package com.dean.practice.algorithm.array;

import java.util.Arrays;

/*
 * 问题: Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * 示例:
 * Input: nums = [2,0,2,1,1,0] Output: [0,0,1,1,2,2]
 *
 * 题解一
 * 分析: 计数排序。
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 *
 * 题解二
 * 分析: 一个指针标记已排序的位置，第一次遍历时找到最小的，与指针位置进行交换，从而将小的值移动到前面。第二次遍历从已排序完成位置开始，
 * 找出第二小的数，与已排序位置交换。
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,0,2,1,1,0,2};
        sortColors3(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors1(int[] nums) {
        int red = 0, white = 0;
        for (int num : nums) {
            if (num == 0) red++;
            else if (num == 1) white++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < red) nums[i] = 0;
            else if (i < red + white) nums[i] = 1;
            else nums[i] = 2;
        }
    }

    public static void sortColors2(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[p];
                nums[p++] = 0;
            }
        }
        for (int i = p; i < nums.length; i++) {
            if (nums[i] == 1) {
                nums[i] = nums[p];
                nums[p++] = 1;
            }
        }
    }

    public static void sortColors3(int[] nums) {
        int p0 = 0, p1 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[p0];
                nums[p0++] = 0;
                // 保证p0 <= p1
                if (p0 > p1) p1 = p0;
            }
            // 存在1被交换到2后面的情况
            if (nums[i] == 1) {
                nums[i] = nums[p1];
                nums[p1++] = 1;
            }
        }
    }
}
