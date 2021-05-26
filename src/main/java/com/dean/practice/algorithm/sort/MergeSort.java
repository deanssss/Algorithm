package com.dean.practice.algorithm.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,4,5,12,0};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums) {
        mergeSortRecursive(nums, 0, nums.length - 1);
    }

    private static void mergeSortRecursive(int[] nums, int start, int end) {
        if (start >= end) return;

        int middle = (start + end) / 2;
        mergeSortRecursive(nums, start, middle);
        mergeSortRecursive(nums, middle + 1, end);

        merge(nums, start, middle, end);
    }

    // 使用额外空间的归并
    // 此方法借鉴了MergeSortedArray中的归并方式，减少了一半额外空间的创建以及ArrayCopy的规模。
    private static void merge(int[] nums, int start, int middle, int end) {
        int[] temp = new int[end - middle];
        // 将数组中已排序的后面部分复制到temp数组中，使原数组后面部分空闲出来，方便后续归并。
        System.arraycopy(nums, middle + 1, temp, 0, temp.length);

        // 从后向前归并，大的数移动到原始数组的尾部。
        int i = middle, j = temp.length - 1, p = end;
        while (i >= start && j >= 0) {
            nums[p--] = nums[i] > temp[j]
                    ? nums[i--]
                    : temp[j--];
        }

        // temp中还剩元素没有被合并，直接复制到原始数组的开头。
        if (j >= 0) {
            System.arraycopy(temp, 0, nums, start, j + 1);
        }
    }
}
