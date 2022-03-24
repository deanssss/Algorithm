package com.dean.practice.algorithm.list

import org.junit.Test

import org.junit.Assert.*

class FlattenMultilevelListTest {
    private val flattenList = FlattenMultilevelList()
    private val cases = listOf(
        TestCase(
            head = listOf(1, 2, 3, 4, 5, 6, null, null, null, 7, 8, 9, 10, null, null, 11, 12),
            output = listOf(1, 2, 3, 7, 8, 11, 12, 9, 10, 4, 5, 6),
        ),
        TestCase(
            head = listOf(1, 2, null, 3),
            output = listOf(1, 3, 2),
        ),
        TestCase(
            head = listOf(),
            output = listOf(),
        )
    )

    @Test
    fun flatten() {
        cases.map {
            val list1 = ListUtil.buildLayerListFromValues(it.head)
            println("Input: head=${it.head}")
            println("Expect: ${it.output}")
            val res = flattenList.flatten(list1)
            val resStr = ListUtil.parseLayerListToArrayStr(res)
            println("Result: $resStr")
            println("==========================")
            assert(it.output.toString() == resStr)
        }
    }

    private data class TestCase(
        val head: List<Int?>,
        val output: List<Int>,
    )
}