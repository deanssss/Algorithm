package com.dean.practice.algorithm.array;

/*
 * https://leetcode-cn.com/leetbook/read/all-about-array/x96n4v/
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 */
public class MaxVolume {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1};
        System.out.println(maxVolume(nums));
    }

    public static int maxVolume(int[] height) {
        int head = 0, tail = height.length - 1;
        int maxVolume = 0, volume;

        while (head < tail) {
            volume = (tail - head) * Math.min(height[head], height[tail]);
            maxVolume = Math.max(maxVolume, volume);
            if (height[head] > height[tail]) {
                tail--;
            } else {
                head++;
            }
        }
        return maxVolume;
    }
}
