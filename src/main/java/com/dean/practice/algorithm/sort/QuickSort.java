package com.dean.practice.algorithm.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,4,5,12,0};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums) {
        quickSortRecursive(nums, 0, nums.length - 1);
    }

    private static void quickSortRecursive(int[] nums, int start, int end) {
        if (start >= end) return;

        int p = partition(nums, start, end);

        // p的位置已经确定好，因此后续无需再将p加入到排序范围。
        quickSortRecursive(nums, start, p - 1);
        quickSortRecursive(nums, p + 1, end);
    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[end], temp;
        int i = start, j = start;

        while (j <= end - 1) {
            if (nums[j] < pivot) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            j++;
        }
        nums[end] = nums[i];
        nums[i] = pivot;
        return i;
    }
}
