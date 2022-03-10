package com.dean.practice.algorithm.list

import org.junit.Test

class PalindromeListTest {
    private val palindrome = PalindromeList()
    private val cases = listOf(
        TestCase(
            listOf(1, 2, 2, 1),
            true,
        ),
        TestCase(
            listOf(1, 2),
            false,
        ),
        TestCase(
            listOf(1),
            true,
        ),
        TestCase(
            listOf(),
            true,
        ),
    )

    @Test
    fun isPalindrome() {
        cases.map {
            val list = ListUtil.buildFromValues(it.head)
            println("Input: head=${it.head}")
            println("Expect: ${it.output}")
            val res = palindrome.isPalindrome(list)
            println("Result: $res")
            println("==========================")
            assert(it.output == res)
        }
    }

    private data class TestCase(
        val head: List<Int>,
        val output: Boolean,
    )
}