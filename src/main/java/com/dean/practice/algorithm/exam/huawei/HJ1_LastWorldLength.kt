package com.dean.practice.algorithm.exam.huawei

import java.util.Scanner

// 求字符串最后一个单词的长度
fun main(args: Array<String>) {
    val read = Scanner(System.`in`)
    while(read.hasNextLine()) {
        val str = read.nextLine()
        val index = str.lastIndexOf(' ')
        println(if (index == -1) str.length else str.length - index - 1)
    }
}