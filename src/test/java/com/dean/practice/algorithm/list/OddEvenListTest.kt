package com.dean.practice.algorithm.list

import org.junit.Test

class OddEvenListTest {
    private val oeList = OddEvenList()
    private val cases = listOf(
        TestCase(
            listOf(1, 2, 3, 4, 5),
            listOf(1, 3, 5, 2, 4),
        ),
        TestCase(
            listOf(2, 1, 3, 5, 6, 4, 7),
            listOf(2, 3, 6, 7, 1, 5, 4),
        ),
        TestCase(
            listOf(1, 2, 3),
            listOf(1, 3, 2),
        ),
        TestCase(
            listOf(1, 2),
            listOf(1, 2),
        ),
        TestCase(
            listOf(1),
            listOf(1),
        ),
        TestCase(
            listOf(),
            listOf(),
        ),
    )

    @Test
    fun oddEvenList() {
        cases.map {
            val list = ListUtil.buildFromValues(it.head)
            println("Input: head=${it.head}")
            println("Expect: ${it.output}")
            val res = oeList.oddEvenList(list)
            val reStr = ListUtil.parseListToArrayStr(res)
            println("Result: $reStr")
            println("==========================")
            assert(it.output.toString() == reStr)
        }
    }

    data class TestCase(
        val head: List<Int>,
        val output: List<Int>,
    )
}