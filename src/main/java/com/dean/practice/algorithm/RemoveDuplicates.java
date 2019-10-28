package com.dean.practice.algorithm;

/*
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2};
        int length = removeDuplicates(nums);
        System.out.println(length);
        System.out.println();

        for (int i = 0; i < length; i++) {
            System.out.print(nums[i]);
        }
    }

    private static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int stash = nums[0];
        int pointer = 1;
        for (int i = 1; i < nums.length; i++) {
            if (stash != nums[i]) {
                nums[pointer++] = nums[i];
                stash = nums[i];
            }
        }
        return pointer;
    }
}
