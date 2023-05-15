package com.dean.practice.algorithm.tree

data class TreeNode<T>(
    val value: T,
    var left: TreeNode<T>? = null,
    var right: TreeNode<T>? = null
)