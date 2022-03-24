package com.dean.practice.algorithm.list.base

class LayerListNode(val value: Int) {
    var prev: LayerListNode? = null
    var next: LayerListNode? = null
    var child: LayerListNode? = null
}