package com.dean.practice.algorithm.exam.huawei

import java.util.Scanner

// 删除随机数字序列中重复的数并排序
fun main(args: Array<String>) {
    val read = Scanner(System.`in`)
    while(read.hasNextInt()) {
        (0 until read.nextInt())
            .asSequence()
            .map { read.nextInt() }
            .toSortedSet()
            .forEach { println(it) }
    }
}