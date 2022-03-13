package com.dean.practice.algorithm.list

import org.junit.Test

class AddTwoNumbersTest {
    private val add = AddTwoNumbers()
    private val cases = listOf(
        TestCase(
            listOf(2, 4, 3),
            listOf(5, 6, 4),
            listOf(7, 0, 8),
        ),
        TestCase(
            listOf(0),
            listOf(0),
            listOf(0),
        ),
        TestCase(
            listOf(9, 9, 9, 9, 9, 9, 9),
            listOf(9, 9, 9, 9),
            listOf(8, 9, 9, 9, 0, 0, 0, 1),
        )
    )

    @Test
    fun addTwoNumbers() {
        cases.map {
            val list1 = ListUtil.buildFromValues(it.l1)!!
            val list2 = ListUtil.buildFromValues(it.l2)!!
            println("Input: l1=${it.l1} l2=${it.l2}")
            println("Expect: ${it.output}")
            val res = add.addTwoNumbers(list1, list2)
            val resStr = ListUtil.parseListToArrayStr(res)
            println("Result: $resStr")
            println("==========================")
            assert(it.output.toString() == resStr)
        }
    }

    private class TestCase(
        val l1: List<Int>,
        val l2: List<Int>,
        val output: List<Int>,
    )
}