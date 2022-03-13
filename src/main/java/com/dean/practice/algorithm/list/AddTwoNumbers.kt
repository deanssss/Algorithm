package com.dean.practice.algorithm.list

import com.dean.practice.algorithm.list.base.ListNode

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode {
        val res = ListNode(-1)
        var p1: ListNode? = l1
        var p2: ListNode? = l2
        var p3 = res

        var acc = 0
        while (p1 != null && p2 != null) {
            acc = p1.`val` + p2.`val` + acc / 10
            p3.next = ListNode(acc % 10)
            p1 = p1.next
            p2 = p2.next
            p3 = p3.next
        }

        p1 = p1 ?: p2
        // 不同位数的数字相加，处理大数高位部分
        while (p1 != null) {
            acc = p1.`val` + acc / 10
            p3.next = ListNode(acc % 10)
            p1 = p1.next
            p3 = p3.next
        }
        // 处理最后的进位
        if (acc / 10 > 0) p3.next = ListNode(1)

        return res.next
    }
}