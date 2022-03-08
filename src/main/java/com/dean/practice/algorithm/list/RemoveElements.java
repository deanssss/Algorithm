package com.dean.practice.algorithm.list;

import com.dean.practice.algorithm.list.base.ListNode;

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) return null;
        ListNode p = head;

        while (p != null) {
            if (p.next != null && p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }

        return head;
    }

    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements1(head.next, val);
        return head.val == val ? head.next : head;
    }
}
