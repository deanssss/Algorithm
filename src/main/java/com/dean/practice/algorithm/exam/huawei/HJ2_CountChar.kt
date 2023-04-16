package com.dean.practice.algorithm.exam.huawei

import java.util.Scanner

// 计算字符串中某个字符出现次数
fun main(args: Array<String>) {
    val read = Scanner(System.`in`)
    while(read.hasNextLine()) {
        val str = read.nextLine().toUpperCase()
        val c = read.nextLine().first().toUpperCase()
        val count = str.asIterable().count { it == c }
        println(count)
    }
}