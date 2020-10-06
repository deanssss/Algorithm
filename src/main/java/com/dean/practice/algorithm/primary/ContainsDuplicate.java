package com.dean.practice.algorithm.primary;

/*
 * 问题：给定一个整数数组，判断是否存在重复元素。
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * 示例：
 * Input: [1,2,3,1] Output: true
 * Input: [1,2,3,4] Output: false
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,1};
        System.out.println(containsDuplicate(nums));
        System.out.println(sortDuplicate(nums));
    }

    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            boolean b = numSet.add(num);
            if (!b) return true;
        }
        return false;
    }

    private static boolean sortDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }
}
