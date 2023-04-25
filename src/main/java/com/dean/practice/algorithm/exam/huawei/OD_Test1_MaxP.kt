package com.dean.practice.algorithm.exam.huawei

import java.util.*

/*
某个充电站，可提供n个充电设备，每个充电设备均有对应的输出功率。
任意个充电设备组合的输出功率总和，均构成功率集合P的1个元素。
功率集合P的最优元素，表示最接近充电站最大输出功率P_max的元素

# 输入描述
输入为3行:
第1行为充电设备个数n
第2行为每个充电设备的输出功率P_i
第3行为充电站最大输出功率P_max

# 输出描述
功率集合P的最优元素

# 备注
充电设备个数 n >0
最优元素必须小于或等于充电站最大输出功率P_max

# 示例1：
## 输入
4
50 20 20 60
90

## 输出
90

## 说明
当充电设备输出功率50、20、20组合时，其输出功率总和为90，最接近充电站最大充电输出功率，因此最优元素为90。

# 示例2：
2
50 40
30

## 输出
0

## 说明
所有充电设备的输出功率组合，均大于充电站最大充电输出功率30，此时最优元素值为0。
 */

var maxP = 0
fun main() {
    val scanner = Scanner(System.`in`)
    val deviceNum = scanner.nextInt()
    val deviceP = mutableListOf<Int>()
    for (i in 0 until deviceNum) {
        deviceP.add(scanner.nextInt())
    }
    maxP = scanner.nextInt()
    backtrack(deviceP)
    println(realMaxP)

    println("dp result: " + dp(deviceP))
    println("dp2 result: " + dp2(deviceP))
}

var realMaxP = 0
val memo = hashMapOf<Int, MutableList<Int>>()
fun backtrack(deviceP: List<Int>) {
    doBacktrack(deviceP, 0, 0)
}

fun doBacktrack(deviceP: List<Int>, index: Int, p: Int) {
    // 已经考察过此情况了
    if (memo[index]?.contains(p) == true) return
    println("doBacktrack: index=$index, p=$p")
    if (p in (realMaxP + 1)..maxP) realMaxP = p
    // 验证完了 或者 已达理论最大值了
    if (index >= deviceP.size || realMaxP >= maxP) return

    val dp = deviceP[index]
    // 不用此设备
    doBacktrack(deviceP, index + 1, p)
    // 用此设备
    doBacktrack(deviceP, index + 1, p + dp)
}

fun dp(deviceP: List<Int>): Int {
    val states = Array(deviceP.size) { BooleanArray(maxP + 1) }
    var dp = deviceP[0]
    states[0][0] = true
    if (dp <= maxP) {
        states[0][dp] = true
    }

    for (i in 1 until deviceP.size) {
        dp = deviceP[i]
        for (j in 0 .. maxP) {
            if (states[i - 1][j]) states[i][j] = states[i - 1][j]
        }
        for (j in 0 .. (maxP - dp)) {
            if (states[i - 1][j]) states[i][j + dp] = true
        }
    }
    println("======")
    println((0 .. maxP).joinToString { "%2d".format(it) })
    states.forEach {
        println(it.joinToString { if (it) " X" else " 0" })
    }
    println("======")
    return states.last().indexOfLast { it }
}

fun dp2(deviceP: List<Int>): Int {
    val states = BooleanArray(maxP + 1)
    var dp = deviceP[0]
    states[0] = true
    if (dp <= maxP) {
        states[dp] = true
    }

    for (i in 1 until deviceP.size) {
        dp = deviceP[i]
        for (j in (maxP - dp) downTo 0) {
            if (states[j]) states[j + dp] = true
        }
    }
    println("======")
    println((0 .. maxP).joinToString { "%2d".format(it) })
    println(states.joinToString { if (it) " X" else " 0" })
    println("======")
    return states.indexOfLast { it }
}