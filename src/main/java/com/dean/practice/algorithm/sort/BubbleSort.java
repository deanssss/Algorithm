package com.dean.practice.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,2,1,5};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void bubbleSort(int[] nums) {
        int sorted = nums.length;
        while (bubble(nums, sorted) && sorted > 1) sorted--;
    }

    private static boolean bubble(int[] nums, int sorted) {
        int temp;
        boolean hasSorted = false;
        for (int i = 1; i < sorted; i++) {
            if (nums[i - 1] > nums[i]) {
                temp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = temp;
                hasSorted = true;
            }
        }
        return hasSorted;
    }
}
