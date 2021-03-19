package com.dean.practice.algorithm.array;

import java.util.Arrays;
import java.util.Random;

/*
 * 问题: https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 *
 * 示例:
 * Input: nums = [3,2,1,5,6,4], k = 2 Output: 5
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4 Output: 4
 * 
 * 题解一
 * 分析: 选择排序。
 *
 * 时间复杂度: O(k*n)
 * 空间复杂度: O(1)
 *
 * 题解二
 * 分析: 快速选择，利用快排思想，首先随机选择数组中的一个数x，将大于等于这个数的放在数组左边，小于这个数的放右边，如此可以确定x在排序后的数组中的位置p。
 * 如果位置p恰好等于k-1，则说明这个数就是第k大的数。如果这个位置p大于k - 1，则说明第k大的数在数组的左半边，那么递归的对左半边数组执行前面的操作，
 * 直到确定出那个位置在k-1的数。同样的，对于位置p小于k - 1的情况，递归处理右半部分的数组。
 *
 * 时间复杂度:
 * 空间复杂度:
 */
public class FindKthLargest {
    private static final Random random = new Random();

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        int k = 5;

        System.out.println(Arrays.toString(nums));
        System.out.println("--------------------------");
        System.out.println(findKthLargest2(nums, k));
        System.out.println("--------------------------");
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static int findKthLargest1(int[] nums, int k) {
        int max, tmp;
        for (int i = 0; i < k; i++) {
            max = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[max] < nums[j]) max = j;
            }

            tmp = nums[i];
            nums[i] = nums[max];
            nums[max] = tmp;
        }
        return nums[k - 1];
    }

    public static int findKthLargest2(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private static int quickSelect(int[] nums, int start, int end, int k) {
        int p = partition(nums, start, end);

        if (p == k - 1) {
            return nums[p];
        } else {
            return p > k - 1
                    ? quickSelect(nums, start, p - 1, k)
                    : quickSelect(nums, p + 1, end, k);
        }
    }

    private static int partition(int[] nums, int start, int end) {
        int rand = random.nextInt(end - start + 1) + start;
        int x = nums[rand], pointer = start;
        nums[rand] = nums[start];
        nums[start] = x;
        System.out.println(Arrays.toString(nums) + " random=" + rand + " start=" + start + " end=" + end);

        for (int i = start + 1; i <= end; i++) {
            if (nums[i] >= x) {
                swap(nums, ++pointer, i);
                System.out.println(Arrays.toString(nums) + " pointer=" + pointer);
            }
        }
        swap(nums, pointer, start);
        System.out.println(Arrays.toString(nums) + "--->");
        return pointer;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
