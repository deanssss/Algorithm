package com.dean.practice.algorithm.list

import com.dean.practice.algorithm.list.base.ListNode

class PalindromeList {
    var tail: ListNode? = null

    fun isPalindrome(head: ListNode?) =
        if (head?.next != null) check(head, head) else true

    fun check(slow: ListNode, fast: ListNode?): Boolean {
        // fast或者其next为null时，表示slow已经指向了中间节点，可以退递归了
        if (fast == null) {
            // 偶数个节点，slow已经指向了回文串后半段的开始
            tail = slow
            return true
        }
        if (fast.next == null) {
            // 奇数个节点，slow指向了中间节点，next才是回文串后半段的开始
            tail = slow.next
            return true
        }
        // 用上一层的slow和下一层设置的tail节点对比，本层则继续将tail设置为其next。
        // 也就是倒序输出链表的原理。
        val res = check(slow.next, fast.next.next)
                && (slow.`val` == tail?.`val`)
        tail = tail?.next
        return res
    }
}