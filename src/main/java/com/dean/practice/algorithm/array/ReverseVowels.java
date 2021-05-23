package com.dean.practice.algorithm.array;

import java.util.function.Function;

/*
 * https://leetcode-cn.com/leetbook/read/all-about-array/x93lce/
 *
 * Input: s = "leetcode"
 * Output: "leotcede"
 */
public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(reverseVowels("aA"));
    }

    // 还是对撞指针
    public static String reverseVowels(String s) {
        int head = 0, tail = s.length() - 1;
        char h, t;
        Function<Character, Boolean> isVowel = c -> {
            c = ((char) (c | 0x20));
            return c == 'a'
                    || c == 'e'
                    || c == 'i'
                    || c == 'o'
                    || c == 'u';
        };
        StringBuilder sb = new StringBuilder(s);

        while (head < tail) {
            h = sb.charAt(head);
            t = sb.charAt(tail);

            if (!isVowel.apply(h)) {
                head++;
                continue;
            }
            if (!isVowel.apply(t)) {
                tail--;
                continue;
            }
            sb.setCharAt(tail, h);
            sb.setCharAt(head, t);
            head++;
            tail--;
        }
        return sb.toString();
    }
}
