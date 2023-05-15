package com.dean.practice.algorithm.tree

fun main() {
    val tree = SortedTree<Int>()
    listOf(13, 8, 18, 6, 10, 16, 20, 18, 19).forEach {
        tree.addNode(it)
    }
    val node = tree.deleteNode(18)
    println(node.size)
}

/**
 * 待删除的节点 - 该节点的前驱节点
 */
typealias DeletePair<T> = Pair<TreeNode<T>, TreeNode<T>?>

class SortedTree<T : Comparable<T>> {
    var root: TreeNode<T>? = null

    fun addNode(t: T) {
        val node = TreeNode(t)
        if (root == null) {
            root = node
            return
        }
        var p = root
        while (p != null) {
            if (p.value <= t) {
                // 相等视为大于，继续往右子树上找插入点
                if (p.right != null) p = p.right
                else {
                    p.right = node
                    return
                }
            } else {
                if (p.left != null) p = p.left
                else {
                    p.left = node
                    return
                }
            }
        }
    }

    fun findNode(t: T): List<TreeNode<T>> {
        val nodes = mutableListOf<TreeNode<T>>()
        var p = root
        while (p != null) {
            p = when {
                p.value > t -> p.left
                p.value < t -> p.right
                else -> {
                    nodes.add(p)
                    // 找到一个继续在右子树上找其它的
                    p.right
                }
            }
        }
        return nodes
    }

    fun deleteNode(t: T): List<TreeNode<T>> {
        val deletePairs = mutableListOf<DeletePair<T>>()
        var p: TreeNode<T>? = root
        var preP: TreeNode<T>? = null

        // 查找，找要删除的节点以及它的父节点，因为存在重复节点，
        // 所以需要先从最下面的节点开始删除。
        while (p != null) {
            if (p.value == t) {
                deletePairs.add(p to preP)
            }
            // 即使找到了后也要继续查找，把所有的都找出来
            preP = p
            p = if (p.value <= t) p.right else p.left
        }

        for (i in deletePairs.size - 1 downTo 0) {
            // 从最下面开始逐一往上删除
            val deletePair = deletePairs[i]
            realDelete(deletePair.first, deletePair.second)
        }
        return deletePairs.map { it.first }
    }

    private fun realDelete(p: TreeNode<T>, preP: TreeNode<T>?) {
        if (p.left == null && p.right == null) {
            // 是叶子节点
            replace(preP, p, null)
        } else if (p.left == null) {
            // 只有右子树
            replace(preP, p, p.right)
        } else if (p.right == null) {
            // 只有左子树
            replace(preP, p, p.left)
        } else {
            // 左右都健在
            // 先从右子树上找最小的
            var minPreP: TreeNode<T> = p
            var minP = p.right!!
            while (minP.left != null) {
                minPreP = minP
                minP = minP.left!!
            }
            // 然后删除它
            if (minPreP.left == minP) minPreP.left = null
            else minPreP.right = null
            // 然后替代要删除的节点
            minP.left = p.left
            minP.right = p.right
            replace(preP, p, minP)
        }
    }

    private fun replace(preP: TreeNode<T>?, p: TreeNode<T>, replaceP: TreeNode<T>?) {
        if (preP == null) root = replaceP
        else if (preP.left == p) preP.left = replaceP
        else preP.right = replaceP
    }
}