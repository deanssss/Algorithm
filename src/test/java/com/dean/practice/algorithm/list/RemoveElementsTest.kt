package com.dean.practice.algorithm.list

import org.junit.Test

class RemoveElementsTest {
    private val removes = RemoveElements()
    private val cases = listOf(
        TestCase(
            head = listOf(1, 2, 3, 4, 5, 6),
            value = 6,
            output = listOf(1, 2, 3, 4, 5),
        ),
        TestCase(
            head = listOf(),
            value = 1,
            output = listOf(),
        ),
        TestCase(
            head = listOf(7, 7, 7, 7),
            value = 7,
            output = listOf(),
        ),
    )

    @Test
    fun removeElements() {
        cases.map {
            val list = ListUtil.buildFromValues(it.head)
            println("Input: head=${it.head}, n=${it.value}")
            println("Expect: ${it.output}")
            val res = removes.removeElements(list, it.value)
            val reStr = ListUtil.parseListToArrayStr(res)
            println("Result: $reStr")
            println("==========================")
            assert(it.output.toString() == reStr)
        }
    }

    @Test
    fun removeElements1() {
        cases.map {
            val list = ListUtil.buildFromValues(it.head)
            println("Input: head=${it.head}, n=${it.value}")
            println("Expect: ${it.output}")
            val res = removes.removeElements1(list, it.value)
            val reStr = ListUtil.parseListToArrayStr(res)
            println("Result: $reStr")
            println("==========================")
            assert(it.output.toString() == reStr)
        }
    }

    private data class TestCase(
        val head: List<Int>,
        val value: Int,
        val output: List<Int>,
    )
}