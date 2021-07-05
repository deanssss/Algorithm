package com.dean.practice.algorithm.list

import org.junit.Test

class TestRemoveNthFromEnd {
    private val rnfe = RemoveNthFromEnd()

    @Test fun test_removeNthFromEnd() {
        val cases = listOf(
            TestCase(
                input = TestCase.Input(intArrayOf(1, 2, 3, 4, 5), 2),
                output = TestCase.Output(listOf(1, 2, 3, 5))
            ),
            TestCase(
                input = TestCase.Input(intArrayOf(2), 1),
                output = TestCase.Output(emptyList())
            ),
            TestCase(
                input = TestCase.Input(intArrayOf(1, 2), 1),
                output = TestCase.Output(listOf(1))
            )
        )
        cases.map {
            val head = ListUtil.buildFromValues(*it.input.head)
            val r = rnfe.removeNthFromEnd(head, it.input.n)
            println("Input: head=${it.input.head.contentToString()}, n=${it.input.n}")
            println("Expect: ${it.output.list}")
            val rStr = ListUtil.parseListToArrayStr(r)
            println("Real: $rStr")
            println("=================================")
            assert(rStr == it.output.list.toString())
        }
    }

    private data class TestCase(
        val input: Input,
        val output: Output
    ) {
        data class Input(
            val head: IntArray,
            val n: Int
        )

        data class Output(
            val list: List<Int>
        )
    }
}