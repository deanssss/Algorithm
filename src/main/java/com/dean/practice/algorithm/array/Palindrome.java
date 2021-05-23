package com.dean.practice.algorithm.array;

/*
 * https://leetcode-cn.com/leetbook/read/all-about-array/x9tqjc/
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 */
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(",P"));
    }

    // 对撞指针法
    public static boolean isPalindrome(String s) {
        int length = s.length(), head = 0, tail = length - 1;
        char h, t;

        while (head < tail) {
            do {
                h = s.charAt(head);
            } while (!Character.isLetterOrDigit(h) && ++head <= tail);

            do {
                t = s.charAt(tail);
            } while (!Character.isLetterOrDigit(t) && head <= --tail);

            if (Character.toLowerCase(h) != Character.toLowerCase(t)) {
                return false;
            }
            head++;
            tail--;
        }

        return true;
    }
}
