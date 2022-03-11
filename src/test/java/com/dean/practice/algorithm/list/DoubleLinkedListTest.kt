package com.dean.practice.algorithm.list

import org.junit.Test

class DoubleLinkedListTest {
    @Test
    fun test() {
        val list = DoubleLinkedList()
        list.addAtHead(2)
        list.deleteAtIndex(1)
        list.addAtHead(2)
        list.addAtHead(7)
        list.addAtHead(3)
        list.addAtHead(2)
        list.addAtHead(5)
        list.addAtTail(5)
        list.get(5).apply { println(this) }
        list.deleteAtIndex(6)
        list.deleteAtIndex(4)

//        assert(list[0] == 1)
//        assert(list[1] == 3)
//        assert(list[2] == -1)
    }
}