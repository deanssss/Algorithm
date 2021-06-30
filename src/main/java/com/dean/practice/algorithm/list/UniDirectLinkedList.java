package com.dean.practice.algorithm.list;

/*
 * LC.707 链表设计的单链表版本，有头节点。
 */
public class UniDirectLinkedList {
    private Node head = new Node(); // empty head node
    private int size = 0;

    public UniDirectLinkedList() {
    }

    int get(int index) {
        if (index < 0 || index >= size)
            return -1;

        Node p = head.next;
        int i = 0;
        while (i < index) {
            p = p.next;
            i++;
        }
        return p.val;
    }

    void addAtHead(int val) {
        addAtIndex(0, val);
    }

    void addAtTail(int val) {
        addAtIndex(size, val);
    }

    void addAtIndex(int index, int val) {
        if (index < 0 || index > size)
            return;

        Node p = head.next, prev = head;
        int i = 0;
        while (i < index) {
            prev = p;
            p = p.next;
            i++;
        }

        Node newNode = new Node();
        newNode.val = val;
        newNode.next = p;
        prev.next = newNode;
        size++;
    }

    void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;

        Node p = head.next, prev = head;
        int i = 0;
        while (i < index) {
            prev = p;
            p = p.next;
            i++;
        }
        prev.next = p.next;
        p.next = null;
        size--;
    }

    private static class Node {
        int val;
        Node next;
    }

    public static void main(String[] args) {
        UniDirectLinkedList linkedList = new UniDirectLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        System.out.println(linkedList.get(1));            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.get(1));            //返回3
    }
}
