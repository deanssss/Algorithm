package com.dean.practice.algorithm.list.base;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public void print() {
        print(this);
    }

    public static void print(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print("" + p.val + "->");
            p = p.next;
        }
        System.out.println("null");
    }
}
