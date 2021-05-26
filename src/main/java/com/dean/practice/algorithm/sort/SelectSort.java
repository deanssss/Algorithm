package com.dean.practice.algorithm.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,4,5,12,0};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void selectSort(int[] nums) {
        int length = nums.length, min, temp;
        for (int sorted = 0; sorted < length; sorted++) {
            min = select(nums, sorted, length);
            temp = nums[sorted];
            nums[sorted] = nums[min];
            nums[min] = temp;
        }
    }

    private static int select(int[] nums, int start, int end) {
        int min = start;
        for (int i = start + 1; i < end; i++) {
            if (nums[min] > nums[i]) min = i;
        }
        return min;
    }
}
