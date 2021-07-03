package com.dean.practice.algorithm.list;

import com.dean.practice.algorithm.list.base.ListNode;

import java.util.HashSet;

public class CycleLinkedList {
    public static boolean hasCycle1(ListNode head) {
        ListNode slow = head, fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }

            if (slow == fast && slow != null)
                return true;
        }
        return false;
    }

    public static ListNode hasCycle2(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode p = head;

        while (p != null) {
            if (!hashSet.add(p))
                return p;
            p = p.next;
        }
        return null;
    }

    public static ListNode hasCycle3(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) fast = fast.next;
            if (slow == fast) break;
        }

        if (fast == null) {
            return null;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
//
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        System.out.println(hasCycle3(n1).val);
    }
}
