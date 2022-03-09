package com.dean.practice.algorithm.list

import com.dean.practice.algorithm.list.base.ListNode

class OddEvenList {
    fun oddEvenList(head: ListNode?): ListNode? {
        head?.next ?: return head

        var oddPtr: ListNode = head
        var evenPtr: ListNode = head.next
        val evenHead: ListNode = evenPtr

        var ptr: ListNode? = evenPtr.next
        var isOdd = true
        oddPtr.next = null
        evenPtr.next = null

        while (ptr != null) {
            val temp = ptr
            ptr = ptr.next
            temp.next = null
            if (isOdd) {
                oddPtr.next = temp
                oddPtr = temp
            } else {
                evenPtr.next = temp
                evenPtr = temp
            }
            isOdd = !isOdd
        }

        oddPtr.next = evenHead
        return head
    }
}