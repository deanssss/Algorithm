package com.dean.practice.algorithm.dp

import kotlin.math.max

fun main() {
    val weight = listOf(2, 2, 4, 6, 3)
    val value = listOf(3, 4, 8, 9, 6)
    ZeroOnePackNormal.knapsack(weight, value, 9)
    ZeroOnePackNormal.knapsack2(weight, value, 9)
    ZeroOnePackNormal.knapsack3(weight, value, 9)
}

object ZeroOnePackNormal {
    fun knapsack(weight: List<Int>, value: List<Int>, maxW: Int) {
        // dp数组的值表示 在处理第i个物品时，背包内容物质量为j时最大价值
        val dp = Array(weight.size) { IntArray(maxW + 1) { -1 } }
        // 处理第0行
        dp[0][0] = 0 // 不装
        if (weight[0] < maxW) {
            dp[0][weight[0]] = value[0] // 装
        }

        // 处理剩下的行
        for (i in 1 until weight.size) {
            // 不装
            for (j in 0..maxW) {
                if (dp[i - 1][j] >= 0) dp[i][j] = dp[i - 1][j]
            }
            // 装
            for (j in 0..(maxW - weight[i])) {
                if (dp[i - 1][j] >= 0) { // 这个容量有过解了
                    val newValue = dp[i - 1][j] + value[i]
                    // 对比旧的解和新解，做替换
                    if (newValue > dp[i][j + weight[i]]) {
                        dp[i][j + weight[i]] = newValue
                    }
                }
            }
        }
        println(dp[weight.size - 1].joinToString())
        println(dp.last().maxOrNull())
    }

    // 不装时，数据和上层是一样的，因此两层可以合并一下
    fun knapsack2(weight: List<Int>, value: List<Int>, maxW: Int) {
        val dp = IntArray(maxW + 1) { -1 }
        // 处理第0行
        dp[0] = 0 // 不装
        if (weight[0] < maxW) {
            dp[weight[0]] = value[0] // 装
        }

        // 处理剩下的行
        for (i in 1 until weight.size) {
            // 只考虑装这个物品的情况
            // 倒过来处理，避免本层的新值被用于计算
            for (j in (maxW - weight[i]) downTo 0) {
                if (dp[j] >= 0) {
                    dp[j + weight[i]] = max(dp[j + weight[i]], dp[j] + value[i])
                }
            }
        }
        println(dp.joinToString())
        println(dp.maxOrNull())
    }

    // 和解法1一样的思路，但是用map+list+pair节省空间，在处理容量非常大的场景，或者容量不是整数的情况下比较有效
    fun knapsack3(weight: List<Int>, value: List<Int>, maxW: Int) {
        val dp = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
        dp[0] = mutableListOf(0 to 0)
        if (weight[0] < maxW) {
            dp[0]!!.add(weight[0] to value[0])
        }

        for (i in 1 until weight.size) {
            val list = dp[i - 1] ?: continue
            val newList = mutableListOf<Pair<Int, Int>>()
            newList.addAll(list)
            list.forEach { (w, v) ->
                if (w + weight[i] <= maxW) {
                    val newV = v + value[i]
                    // 要注意容量被我们塞到了pair中了，得遍历查找
                    val index = newList.indexOfFirst { it.first == w + weight[i] }
                    if (index == -1) {
                        newList.add(w + weight[i] to newV)
                    } else if (newList[index].second < newV) {
                        newList[index] = w + weight[i] to newV
                    }
                }
            }
            dp[i] = newList
        }

        println(dp[weight.size - 1]!!.joinToString { "${it.second}" })
        println(dp[weight.size - 1]!!.maxOf { it.second })
    }
}