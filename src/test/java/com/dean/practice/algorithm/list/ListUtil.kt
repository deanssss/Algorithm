package com.dean.practice.algorithm.list

import com.dean.practice.algorithm.list.base.ListNode

object ListUtil {
    fun buildFromValues(vararg values: Int): ListNode? {
        var head: ListNode? = null
        var pre: ListNode? = null
        for (i in values.indices) {
            val newNode = ListNode(values[i])
            if (pre != null) pre.next = newNode
            pre = newNode
            if (i == 0) head = newNode
        }
        return head
    }

    fun buildFromValues(values: List<Int>): ListNode? {
        var head: ListNode? = null
        var pre: ListNode? = null
        for (i in values.indices) {
            val newNode = ListNode(values[i])
            if (pre != null) pre.next = newNode
            pre = newNode
            if (i == 0) head = newNode
        }
        return head
    }

    fun parseListToArrayStr(head: ListNode?): String {
        val list = mutableListOf<Int>()
        var p = head

        while (p != null) {
            list.add(p.`val`)
            p = p.next
        }
        return list.toString()
    }
}