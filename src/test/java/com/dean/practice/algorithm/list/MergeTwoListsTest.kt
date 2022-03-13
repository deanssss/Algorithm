package com.dean.practice.algorithm.list

import org.junit.Test

import org.junit.Assert.*

class MergeTwoListsTest {
    private val merge = MergeTwoLists()
    private val cases = listOf(
        TestCase(
            listOf(1, 2, 4),
            listOf(1, 3, 4),
            listOf(1, 1, 2, 3, 4, 4),
        ),
        TestCase(
            listOf(),
            listOf(),
            listOf()
        ),
        TestCase(
            listOf(),
            listOf(0),
            listOf(0),
        )
    )


    @Test
    fun mergeTwoLists() {
        cases.map {
            val list1 = ListUtil.buildFromValues(it.l1)
            val list2 = ListUtil.buildFromValues(it.l2)
            println("Input: l1=${it.l1} l2=${it.l2}")
            println("Expect: ${it.output}")
            val res = merge.mergeTwoLists(list1, list2)
            val resStr = ListUtil.parseListToArrayStr(res)
            println("Result: $resStr")
            println("==========================")
            assert(it.output.toString() == resStr)
        }
    }

    private data class TestCase(
        val l1: List<Int>,
        val l2: List<Int>,
        val output: List<Int>,
    )
}