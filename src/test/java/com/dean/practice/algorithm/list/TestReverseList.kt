package com.dean.practice.algorithm.list

import org.junit.Test

class TestReverseList {
    private val reverse = ReverseList()

    private val cases = listOf(
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
        ),
    )

    @Test fun  test_reverseList() {
        cases.map {
            val head = ListUtil.buildFromValues(it.input)
            val res = reverse.reverseList(head)
            println("Input:" + it.input.toString())
            println("Expect:" + it.output.toString())
            val reStr = ListUtil.parseListToArrayStr(res)
            println("Result:$reStr")
            println("==========================")
            assert(it.output.toString() == reStr)
        }
    }

    @Test fun  test_reverseList1() {
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

    @Test fun test_reverseListN() {
        listOf(
            TestCaseN(
                listOf(1, 2, 3, 4, 5),
                3,
                listOf(3, 2, 1, 4, 5)
            ),
            TestCaseN(
                listOf(1, 2, 3, 4, 5),
                5,
                listOf(5, 4, 3, 2, 1)
            ),
            TestCaseN(
                listOf(1, 2, 3, 4, 5),
                1,
                listOf(1, 2, 3, 4, 5)
            ),
            TestCaseN(
                listOf(1),
                1,
                listOf(1)
            ),
            TestCaseN(
                listOf(),
                0,
                listOf()
            ),
        ).map {
            val head = ListUtil.buildFromValues(it.input)
            val res = reverse.reverseListN(head, it.n)
            println("Input:${it.input} n=${it.n}")
            println("Expect:${it.output}")
            val reStr = ListUtil.parseListToArrayStr(res)
            println("Result:$reStr")
            println("==========================")
            assert(it.output.toString() == reStr)
        }
    }

    @Test fun test_reverseListMN() {
        listOf(
            TestCaseMN(
                listOf(1, 2, 3, 4, 5, 6),
                3, 5,
                listOf(1, 2, 5, 4, 3, 6),
            )
        ).map {
            val head = ListUtil.buildFromValues(it.input)
            val res = reverse.reverseListMN(head, it.m, it.n)
            println("Input:${it.input} m=${it.m} n=${it.n}")
            println("Expect:${it.output}")
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

    private data class TestCaseN(
        val input: List<Int>,
        val n: Int,
        val output: List<Int>
    )

    private data class TestCaseMN(
        val input: List<Int>,
        val m: Int,
        val n: Int,
        val output: List<Int>
    )
}