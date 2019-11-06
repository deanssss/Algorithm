package com.dean.practice.algorithm.primary;

/*
 * 问题: Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * 示例:
 * Input: [1, 1, 2] Output: 2
 * Input: [0, 0, 1, 1, 2, 2] Output: 3
 *
 * 分析: 题目给定了一个排序数组，要求去除数组中重复的元素，要求空间复杂度为O(1)，即不能创建新的数组。
 * 这里我们采用选择排序的思路，找到不重复的数字将其放置到对应位置上即可，因为原数组已经是排序好的，
 * 因此遍历时判断某个数是否需要被放置只需要判断它是否与已排序部分的最后一个元素不同即可。
 * 为了放置不重复的数使其成为一个新的数组，我们需要一个标志（pointer）来记录当前已经去重完成的部分的尾部，用以放置将来找到新的不重复元素，
 * 同时也可以帮助我们快速的找到已排序部分的最后一个元素。
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 1, 2};
        int length = removeDuplicates(nums);
        System.out.println("length = " + length);
        System.out.print("array  = [" + nums[0]);

        for (int i = 1; i < length; i++) {
            System.out.print(", " + nums[i]);
        }
        System.out.print("]");
    }

    private static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int pointer = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[pointer - 1] != nums[i]) {
                nums[pointer++] = nums[i];
            }
        }
        return pointer;
    }
}
