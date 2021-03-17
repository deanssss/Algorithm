package com.dean.practice.algorithm.array;

import java.util.Arrays;

/*
 * 问题: Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * 示例:
 * Input: nums = [1,1,1,2,2,3] Output: 5, nums = [1,1,2,2,3]
 * Input: nums = [0,0,1,1,1,1,2,3,3] Output: 7, nums = [0,0,1,1,2,3,3]
 *
 * 题解一
 * 分析: 同RemoveDuplicates。
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
public class RemoveDuplicates2 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,1,1,2,2,2,2,3,3};
        int length = removeDuplicates2(nums);
        System.out.println("length = " + length);
        System.out.print("array  = [" + nums[0]);

        for (int i = 1; i < length; i++) {
            System.out.print(", " + nums[i]);
        }
        System.out.print("]");
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int pointer = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[pointer - 2] != nums[i]) {
                System.out.println("counted=" + nums[pointer-2] + " pointer=" + pointer + " i=" +i);
                nums[pointer++] = nums[i];
                System.out.println(Arrays.toString(nums));
            }
        }
        return pointer;
    }
}
