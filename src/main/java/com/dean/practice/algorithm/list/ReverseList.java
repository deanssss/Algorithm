package com.dean.practice.algorithm.list;

import com.dean.practice.algorithm.list.base.ListNode;

public class ReverseList {
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode p = head, q;
        while (p.next != null) {
            q = p.next;
            p.next = q.next;
            q.next = head;
            head = q;
        }
        return head;
    }

    public ListNode reverseList(ListNode head) {
        // 不要跳进递归里，一层递归做一层递归的事，然后处理好终止条件。
        // 1 -> 2 -> 3 -> 4 -> null
        // 1 -> reverse(2 -> 3 -> 4 -> null) 假设已经拿到下一层递归的结果了
        // 1 -> 2 <- 3 <- 4
        //      |
        //     null
        // null <- 1 <- 2 <- 3 <- 4
        if (head == null || head.next == null)
            return head;

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private ListNode successor = null;
    // 简化题目，默认n <= 链表长度
    public ListNode reverseListN(ListNode head, int n) {
        if (head == null) return null;
        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode newHead = reverseListN(head.next, --n);
        head.next.next = head;
        head.next = successor;
        return newHead;
    }

    // 0< m <= n <= list.length
    // https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/yi-bu-yi-bu-jiao-ni-ru-he-yong-di-gui-si-lowt/
    public ListNode reverseListMN(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseListN(head, n);
        }
        head.next = reverseListMN(head.next, m - 1, n - 1);
        return head;
    }
}
