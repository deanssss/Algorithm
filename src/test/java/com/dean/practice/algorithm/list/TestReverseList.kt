package com.dean.practice.algorithm.list

import org.junit.Test

class TestReverseList {
    private val reverse = ReverseList()

    @Test fun  test_reverseList1() {
        val cases = listOf(
            TestCase(
                input = listOf(1, 2, 3, 4, 5),
                output = listOf(5, 4, 3, 2, 1)
            ),
            TestCase(
                input = listOf(1, 2),
                output = listOf(2, 1)
            ),
            TestCase(
                input = listOf(2),
                output = listOf(2)
            ),
            TestCase(
                input = listOf(),
                output = listOf()
            )
        )

        cases.map {
            val head = ListUtil.buildFromValues(it.input)
            val res = reverse.reverseList1(head)
            println("Input:" + it.input.toString())
            println("Expect:" + it.output.toString())
            val reStr = ListUtil.parseListToArrayStr(res)
            println("Result:$reStr")
            println("==========================")
            assert(it.output.toString() == reStr)
        }
    }

    private data class TestCase(
        val input: List<Int>,
        val output: List<Int>
    )
}