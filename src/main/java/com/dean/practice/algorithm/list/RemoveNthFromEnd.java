package com.dean.practice.algorithm.list;

import com.dean.practice.algorithm.list.base.ListNode;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode emptyHead = new ListNode(-1);
        emptyHead.next = head;

        ListNode fast = emptyHead, slow = emptyHead;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return emptyHead.next;
    }
}