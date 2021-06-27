package com.dean.practice.algorithm.list;

import java.util.Objects;

public class DLruCache<T> {
    private final int maxSize;

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public DLruCache(int maxSize) {
        this.maxSize = maxSize >= 2 ? maxSize : 10;
    }

    public void update(T data) {
        Node<T> node = find(data);

        if (node != null) {
            removeNode(node);
            // Set the exists node to head node.
            node.prev = null;
            node.next = head;
        } else {
            node = new Node<>(data, head, null);
            if (size >= maxSize) {
                // Eliminate the oldest data.
                removeNode(tail);
            }
        }

        // Put the data node to head.
        if (head != null) {
            head.prev = node;
        }
        if (tail == null) {
            tail = node;
        }
        head = node;
        size++;

        print();
    }

    private void removeNode(Node<T> n) {
        if (n != tail) {
            n.next.prev = n.prev;
        } else {
            tail = n.prev;
        }

        if (n != head) {
            n.prev.next = n.next;
        } else {
            head = n.next;
        }
        size--;
    }

    protected Node<T> find(T data) {
        if (head == null) return null;

        Node<T> p = head;
        while (p != null && p.data != data && !Objects.equals(p.data, data))
            p = p.next;

        return p;
    }

    public void print() {
        Node<T> p = head;
        while (p != null) {
            System.out.print("" + p.data + "->");
            p = p.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DLruCache<Integer> cache = new DLruCache<>(2);
        cache.update(0);
        cache.update(1);
        cache.update(2);
        cache.update(3);
    }

    static class Node<T> {
        private T data;
        private Node<T> next, prev;

        public Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}
