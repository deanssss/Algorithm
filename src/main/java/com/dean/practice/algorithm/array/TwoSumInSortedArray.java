package com.dean.practice.algorithm.array;

import java.util.Arrays;

/*
 * https://leetcode-cn.com/leetbook/read/all-about-array/x9i1x6/
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class TwoSumInSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-7, -2, 11, 15};
        int target = 4;

//        int[] result = twoSum1(nums, target);
        int[] result = twoSum2(nums, target);
        System.out.println(Arrays.toString(result));
    }

    /*
     * 二分查找，在数组剩下部分二分查找target - nums[i]。
     */
    public static int[] twoSum1(int[] nums, int target) {
        int j;
        for (int i = 0; i < nums.length; i++) {
            j = binarySearch(nums, target - nums[i], i + 1, nums.length - 1);
            if (j != -1) {
                return new int[]{i + 1, j + 1};
            }
        }
        return null;
    }

    public static int binarySearch(int[] nums, int target, int start, int end) {
        int mid, low = start, high = end;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /*
     * 指针对撞，设置头尾两指针，若两位置之和大于target，则说明大值太大，尾指针-1,；若之和小于target则说明小值太小，头指针+1。
     */
    public static int[] twoSum2(int[] nums, int target) {
        int head = 0, tail = nums.length - 1, sum;

        while (head < tail) {
            sum = nums[head] + nums[tail];
            if (sum > target) {
                tail--;
            } else if (sum < target) {
                head++;
            } else {
                return new int[]{head + 1, tail + 1};
            }
        }
        return null;
    }
}
