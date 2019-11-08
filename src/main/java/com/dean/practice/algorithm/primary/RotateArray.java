package com.dean.practice.algorithm.primary;

/*
 * 问题: Given an array, rotate the array to the right by k steps, where k is non-negative.
 * 示例:
 * Input: [1,2,3,4,5,6,7] k = 3 Output: [5,6,7,1,2,3,4]
 * Input: [-1,-100,3,99] k = 2 Output: [3,99,-1,-100]
 *
 * 分析:
 *     方法一: 一步一步的旋转，写完以后会发现idea给出了Array.copy的优化提示，这样可以整块的复制内存，比单个元素移动要快一点。
 *     另外的优化方式是，如果需要循环的步数大于元素个数的一半，就可以反向旋转。
 *     时间复杂度: O(k*n)
 *     空间复杂度: O(1)
 *
 *     方法二: 对数组元素进行翻转（倒序），举个🌰
 *      k = 2
 *      nums: 1 2 3 4 5 6 7
 *          // 翻转整个数组
 *          step-1: 7 6 5 4 3 2 1
 *          // 翻转前k个数
 *          step-2: 6 7 5 4 3 2 1
 *          // 翻转剩下的数
 *          step-3: 6 7 1 2 3 4 5
 *     时间复杂度: O(n)
 *     空间复杂度: O(1)
 */

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,-100};
//        rotate(nums, 2);
        reverse_rotate(nums, 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return;
        int realSteps = k % nums.length; // 去除旋转一整圈的情况
        int centerPos = (nums.length >> 1) + (nums.length & 1);
        boolean doRight = realSteps <= centerPos; // 如果旋转次数大于元素数量的一半，则反向旋转
        realSteps = doRight ? realSteps : nums.length - realSteps; // 计算实际旋转的次数

        int temp;
        for (int step = 0; step < realSteps; step++) {
            if (doRight) {
                temp = nums[nums.length - 1];
                System.arraycopy(nums, 0, nums, 1, nums.length - 1);
                nums[0] = temp;
            } else {
                temp = nums[0];
                System.arraycopy(nums, 1, nums, 0, nums.length - 1);
                nums[nums.length - 1] = temp;
            }
        }
    }
    
    private static void reverse_rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return;
        k %= nums.length;
        if (k == 0) return;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
