package com.dean.practice.algorithm.primary;

/*
 * 问题：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 要求：不使用额外空间，线性时间复杂度。
 *
 * 示例：
 * Input: [2,2,1] Output: 1
 * Input: [4,1,2,1,2] Output: 4
 */

import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[] {4,1,2,1,2};
        System.out.println(singleNumber(nums));
        System.out.println(filterNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i+=2) {
            if (i == nums.length - 1) return nums[i];
            if (nums[i] != nums[i + 1]){
                return nums[i];
            }
        }
        return -1;
    }

    public static int filterNumber(int[] nums) {
        return Arrays.stream(nums).reduce(0, (l, r) -> l ^ r);
//        int single = 0;
//        for (int num : nums) {
//            single ^= num;
//        }
//        return single;
    }
}
