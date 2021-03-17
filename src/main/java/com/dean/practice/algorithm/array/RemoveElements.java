package com.dean.practice.algorithm.array;

import java.util.Arrays;

/*
 * 问题: Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * 示例:
 * Input: nums = [3,2,2,3], val = 3 Output: 2, nums = [2,2]
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2 Output: 5, nums = [0,1,4,0,3]
 * 
 * 题解一
 * 分析: 与MoveZeros同样的解法。
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
public class RemoveElements {
    public static void main(String[] args) {
        int[] nums = new int[]{2};
        int val = 3;
        int res = removeElements1(nums, val);
        System.out.println(res);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeElements1(int[] nums, int val) {
        int moved = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (i != moved) {
                    nums[moved] = nums[i];
                    nums[i] = val;
                }
                moved++;
            }
        }
        return moved;
    }

    public static int removeElements2(int[] nums, int val) {
        if (nums.length == 0) return 0;

        int front = 0, back = nums.length - 1;
        while (front != back) {
            // 从前往后找到要移除的数据位置
            while (front < back && nums[front] != val) front++;
            // 从后往前找到要保留的数据位置
            while (back > front && nums[back] == val) back--;

            // 将后面需要保留的数据移动到前面
            if (front != back) {
                nums[front] = nums[back];
                nums[back] = val;
            }
        }

        if (nums[back] != val) {
            // 没有数据移除的情况
            return back + 1;
        } else {
            return back;
        }
    }
}
