package com.dean.practice.algorithm.list;

import com.dean.practice.algorithm.list.base.ListNode;

public class IntersectionList {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptrA = headA, ptrB = headB;

        while (ptrA != null && ptrB != null) {
            if (ptrA == ptrB) return ptrA;
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }

        if (ptrA == null && ptrB == null)
            return null;

        if (ptrA == null) {
            ptrA = headB;
            while (ptrB != null) {
                ptrA = ptrA.next;
                ptrB = ptrB.next;
            }
            ptrB = headA;
        } else {
            ptrB = headA;
            while (ptrA != null) {
                ptrA = ptrA.next;
                ptrB = ptrB.next;
            }
            ptrA = headB;
        }

        while (ptrA != null && ptrB != null) {
            if (ptrA == ptrB) return ptrA;
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }

        return null;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(8);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(0);
        ListNode n8 = new ListNode(1);

        ListNode headA = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        ListNode headB = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n3;

        System.out.println(getIntersectionNode2(headA, headB).val);
    }
}
