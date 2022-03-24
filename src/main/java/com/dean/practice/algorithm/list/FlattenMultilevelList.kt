package com.dean.practice.algorithm.list

import com.dean.practice.algorithm.list.base.LayerListNode

// https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/
class FlattenMultilevelList {
    fun flatten(head: LayerListNode?): LayerListNode? {
        flatten(head, null)
        return head
    }

    private fun flatten(head: LayerListNode?, tail: LayerListNode?) {
        head ?: return

        var ptr = head
        while (ptr!!.next != null && ptr.child == null) {
            ptr = ptr.next
        }

        if (ptr.child != null) {
            val t = ptr.next
            ptr.next?.prev = null
            ptr.next = ptr.child
            ptr.child!!.prev = ptr
            ptr.child = null
            flatten(ptr.next, t)

            while (ptr!!.next != null) ptr = ptr.next
        }
        ptr.next = tail
        tail?.prev = ptr
    }
}