package com.dean.practice.algorithm.exam.huawei

import java.util.*

// 8个一组分隔字符串
fun main(args: Array<String>) {
    val read = Scanner(System.`in`)
    while(read.hasNext()) {
        val str = read.nextLine()
        val strLen = str.length
        val buffer = CharArray(8)
        var counter = 0
        for (i in str.indices) {
            buffer[i % 8] = str[i]
            counter++
            if (i == strLen - 1 && counter != 8) {
                // 如果是最后一组，末尾加0
                for(index in (counter until 8)) buffer[index] = '0'
                // 最后一组，直接输出咯
                counter = 8
            }
            if (counter == 8) {
                // 成功收集到一组，输出
                buffer.forEach { print(it) }
                counter = 0
            }
        }
    }
}