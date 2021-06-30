package com.dean.practice.algorithm.list;

public class DLinkedList<T> {
    private Node<T> head = null;
    private int size = 0;

    public void add(T data) {
        final Node<T> node = new Node<>(data, null);

        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node<T> p = head;
        while (p.next != null) p = p.next;

        p.next = node;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException("The index is out of bounds. index = " + index + ", size = " + size);

        Node<T> p = head;
        while (index-- > 0) {
            p = p.next;
        }
        return p.data;
    }

    public void reverse() {
        if (head == null || head.next == null)
            return;

        Node<T> p1, p2, p3;

        p1 = head;
        p2 = head.next;
        p3 = null;

        while (p2 != null) {
            p1.next = p3;
            p3 = p1;
            p1 = p2;
            p2 = p2.next;
        }
        p1.next = p3;
        head = p1;
    }

    public void print() {
        Node<T> p = head;
        while (p != null) {
            System.out.print("" + p.data + "->");
            p = p.next;
        }
        System.out.println("null");
    }

    static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this(data, null);
        }
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        DLinkedList list = new DLinkedList();
        list.add(1);
        list.add(2);
        list.print();
        list.reverse();
        list.print();
    }
}
