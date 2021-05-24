package com.dean.practice.algorithm.array;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode-cn.com/leetbook/read/all-about-array/x9gogt/
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 */
public class MinSubArray {
    public static void main(String[] args) {
        List<Pair<Integer, int[]>> datas = new LinkedList<>();
        datas.add(testCase(15, 1,2,3,4,5));
        datas.add(testCase(7, 2,3,1,2,4,3));
        datas.add(testCase(4, 1,4,4));
        datas.add(testCase(11, 1,1,1,1,1,1,1,1));

        for (Pair<Integer, int[]> p : datas) {
            System.out.println("target=" + p.getKey() + " nums=" + Arrays.toString(p.getValue()));
            System.out.println(minSubArrayLen(p.getKey(), p.getValue()));
        }
    }

    // 滑动窗口
    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0;
        int sum = nums[0], minLength = Integer.MAX_VALUE;

        do {
            if (sum >= target) {
                minLength = Math.min(minLength, end - start + 1);
                sum -= nums[start++];
            } else {
                if (end >= nums.length - 1) break;
                sum += nums[++end];
            }
            // 妙啊！若数组中有单个值大小超过target，就会使start超过end，因为不可能存在比size为1还小的子数组，
            // 因此可以提前结束循环。
        } while (start <= end);

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    private static Pair<Integer, int[]> testCase(int a, int ... nums) {
        return new Pair<>(a, nums);
    }
}
