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
        DLinkedList<Integer> list = new DLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.get(10));
    }
}
