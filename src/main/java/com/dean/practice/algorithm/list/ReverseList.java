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

//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null)
//            return head;
//
//        ListNode newHead = reverseList(head.next);
//        head.next.next = head
//    }
}
