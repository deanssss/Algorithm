package com.dean.practice.algorithm.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,4,5,12,0};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void insertSort(int[] nums) {
        int length = nums.length;
        if (length <= 1) return;

        for (int i = 1; i < length; i++) {
            insert(nums, 0, i, i);
        }
    }

    @SuppressWarnings("SameParameterValue")
    private static void insert(int[] nums, int start, int end, int valPos) {
        int temp = nums[valPos], i;
        for (i = end; i > start; i--) {
            if (nums[i - 1] > temp) {
                nums[i] = nums[i - 1];
            } else {
                break;
            }
        }
        nums[i] = temp;
    }
}
