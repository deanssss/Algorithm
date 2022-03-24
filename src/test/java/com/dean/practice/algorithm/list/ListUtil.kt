package com.dean.practice.algorithm.list

import com.dean.practice.algorithm.list.base.LayerListNode
import com.dean.practice.algorithm.list.base.ListNode

object ListUtil {
    fun buildFromValues(vararg values: Int): ListNode? {
        return buildFromValues(values.toList())
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

    fun buildLayerListFromValues(vararg values: Int?): LayerListNode? {
        return buildLayerListFromValues(values.toList())
    }

    fun buildLayerListFromValues(values: List<Int?>): LayerListNode? {
        val head = LayerListNode(-1)
        realBuildLayerList(head, 0, values)
        return head.child
    }

    private fun realBuildLayerList(head: LayerListNode, index: Int, values: List<Int?>) {
        if (values.isEmpty()) {
            head.child = null
            return
        }

        var attachNode: LayerListNode = head
        var i = index
        while (values[i] == null) {
            attachNode = attachNode.next!!
            i++
        }

        val child = LayerListNode(-1)
        var p = child
        for (ii in i until values.size) {
            val value = values[ii]
            if (value != null) {
                val node = LayerListNode(value)
                p.next = node
                node.prev = p
                p = p.next!!
            } else {
                attachNode.child = child.next
                attachNode.child?.prev = null
                child.next = null
                realBuildLayerList(attachNode.child!!, ii + 1, values)
                return // 这一层已经处理完毕，直接退出~
            }
        }
        // 解析最后一层时不会因为节点值为null而将子链表附加到父链表上，所以自己手动设置一下。
        attachNode.child = child.next
        attachNode.child?.prev = null
        child.next = null
    }

    fun parseLayerListToArrayStr(head: LayerListNode?): String {
        val list = mutableListOf<Int?>()
        realParseLayerList(head, list)
        return list.toString()
    }

    private fun realParseLayerList(head: LayerListNode?, list: MutableList<Int?>) {
        var p = head
        var child: LayerListNode? = null
        var childPos = 0
        while (p != null) {
            list.add(p.value)
            if (p.child != null) {
                child = p.child
            }
            p = p.next
            if (child == null) childPos++
        }
        if (child != null) {
            repeat(childPos + 1) { list.add(null) }
            realParseLayerList(child, list)
        }
    }
}