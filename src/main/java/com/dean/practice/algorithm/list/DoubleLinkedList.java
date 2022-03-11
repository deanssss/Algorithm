package com.dean.practice.algorithm.list;

public class DoubleLinkedList {
    private Node head = null;
    private Node tail = null;

    private int count = 0;

    public int get(int index) {
        if (index < 0 || index >= count) return -1;

        Node p = head;
        while (index-- > 0) p = p.next;
        return p.value;
    }

    public void addAtHead(int val) {
        Node newNode = new Node();
        newNode.value = val;

        if (count == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        count++;
        print();
    }

    public void addAtTail(int val) {
        Node newNode = new Node();
        newNode.value = val;

        if (count == 0) {
            tail = newNode;
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        count++;
        print();
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > count) return;

        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == count) {
            addAtTail(val);
            return;
        }

        Node ptr = head;
        Node newNode = new Node();
        newNode.value = val;
        while (index-- > 0) ptr = ptr.next;
        ptr.prev.next = newNode;
        newNode.next = ptr;
        newNode.prev = ptr.prev;
        ptr.prev = newNode;
        count++;
        print();
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index > count - 1) return;

        Node delNode = head;
        if (count == 1) {
            head = null;
            tail = null;
            count--;
            return;
        }
        if (index == 0) {
            head = head.next;
            head.prev = null;
            delNode.next = null;
            count--;
            return;
        }
        if (index == count - 1) {
            delNode = tail;
            tail = tail.prev;
            tail.next = null;
            delNode.prev = null;
            count--;
            return;
        }

        while (index-- > 0) delNode = delNode.next;
        delNode.prev.next = delNode.next;
        delNode.next.prev = delNode.prev;
        delNode.prev = null;
        delNode.next = null;
        count--;
        print();
    }

    static class Node {
        int value;
        Node prev;
        Node next;
    }

    public void print() {
        Node p = head;
        while (p != null) {
            System.out.print(p.value + "->");
            p = p.next;
        }
        System.out.println();
    }
}
