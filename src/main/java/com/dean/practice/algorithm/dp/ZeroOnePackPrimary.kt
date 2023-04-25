package com.dean.practice.algorithm.dp

fun main() {
    val weight = listOf(2, 2, 4, 6, 3)
    ZeroOnePackPrimary.knapsack(weight, 10)
    ZeroOnePackPrimary.knapsack2(weight, 10)
    ZeroOnePackPrimary.knapsack3(weight, 10)
}

object ZeroOnePackPrimary {
    fun knapsack(weight: List<Int>, maxW: Int) {
        // dp数组的值表示 在处理第i个物品时，背包内容物质量为j的情况是否可能存在
        val dp = Array(weight.size) { IntArray(maxW + 1) }
        // 处理第0行
        dp[0][0] = 1 // 不装
        if (weight[0] < maxW) {
            dp[0][weight[0]] = 1 // 装
        }

        // 处理剩下的行
        for (i in 1 until weight.size) {
            // 不装
            for (j in 0..maxW) {
                if (dp[i - 1][j] == 1) dp[i][j] = dp[i - 1][j]
            }
            // 装
            for (j in 0..(maxW - weight[i])) {
                if (dp[i - 1][j] == 1) dp[i][j + weight[i]] = 1
            }
        }
        println(dp.last().indexOfLast { it == 1 })
    }

    // 不装时，数据和上层是一样的，因此两层可以合并一下
    fun knapsack2(weight: List<Int>, maxW: Int) {
        val dp = IntArray(maxW + 1)
        // 处理第0行
        dp[0] = 1 // 不装
        if (weight[0] < maxW) {
            dp[weight[0]] = 1 // 装
        }

        // 处理剩下的行
        for (i in 1 until weight.size) {
            // 只考虑装这个物品的情况
            // 倒过来处理，避免本层的新值被用于计算
            for (j in (maxW - weight[i]) downTo 0) {
                if (dp[j] == 1) dp[j + weight[i]] = 1
            }
        }
        println(dp.indexOfLast { it == 1 })
    }

    // 和解法1一样的思路，但是用map+list节省空间，在处理容量非常大的场景，或者容量不是整数的情况下比较有效
    fun knapsack3(weight: List<Int>, maxW: Int) {
        val dp = mutableMapOf<Int, MutableList<Int>>()
        dp[0] = mutableListOf(0)
        if (weight[0] < maxW) {
            dp[0]!!.add(weight[0])
        }

        for (i in 1 until weight.size) {
            val list = dp[i - 1] ?: continue
            val newList = mutableListOf<Int>()
            newList.addAll(list)
            list.forEach {
                if (it + weight[i] <= maxW) newList.add(it + weight[i])
            }
            dp[i] = newList
        }
        println(dp[weight.size - 1]!!.maxOrNull())
    }
}