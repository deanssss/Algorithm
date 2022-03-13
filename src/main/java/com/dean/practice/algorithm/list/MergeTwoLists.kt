package com.dean.practice.algorithm.list

import com.dean.practice.algorithm.list.base.ListNode

class MergeTwoLists {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        list1 ?: return list2
        list2 ?: return list1

        var p1 = list1
        var p2 = list2
        val newList = if (p1.`val` < p2.`val`) {
            p1 = list1.next
            list1
        } else {
            p2 = list2.next
            list2
        }
        var p3 = newList

        while (p1 != null && p2 != null) {
            if (p1.`val` < p2.`val`) {
                p3.next = p1
                p1 = p1.next
            } else {
                p3.next = p2
                p2 = p2.next
            }
            p3 = p3.next
        }

        if (p1 == null) {
            p3.next = p2
        }
        if (p2 == null) {
            p3.next = p1
        }
        return newList
    }
}