package com.dean.practice.algorithm.exam.huawei

import java.util.*

// 分解质因数
fun main(args: Array<String>) {
    val read = Scanner(System.`in`)
    var num = 0
    var i = 2
    while(read.hasNextInt()) {
        num = read.nextInt()
        i = 2
        while (i * i <= num) {
            while (num % i == 0) {
                num /= i
                print("$i ")
            }
            i++
        }
        if (num != 1) {
            println(num)
        } else {
            println()
        }
    }
}