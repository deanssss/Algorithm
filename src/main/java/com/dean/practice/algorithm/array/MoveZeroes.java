package com.dean.practice.algorithm.array;

import java.util.Arrays;

/*
 * 问题：Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 *
 * 示例：
 * Input: nums = [0,1,0,3,12] Output: [1,3,12,0,0]
 * Input: nums = [0] Output: [0]
 *
 * 分析：双指针法，一个指针记录已经整理完成的位置尾部，另一个指针记录待整理的位置，当待整理位置不为0时，与已整理的尾部执行交换。
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int moved = 0, i = 0;

        for (int len = nums.length; i < len; i ++) {
            if (nums[i] != 0) {
                if (moved != i) {
                    nums[moved] = nums[i];
                }
                moved++;
            }
        }

        for (int len = nums.length; moved < len; moved ++) {
            nums[moved] = 0;
        }
    }
}
