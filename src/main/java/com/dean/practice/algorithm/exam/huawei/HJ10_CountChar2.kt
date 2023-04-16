package com.dean.practice.algorithm.exam.huawei

import java.util.*

fun main(args: Array<String>) {
    val read = Scanner(System.`in`)
    var str: String
    var c: Int
    var bitsHigh: Long
    var bitsLow: Long
    var bitPos: Long
    var count: Int
    while(read.hasNextLine()) {
        str = read.nextLine()
        count = 0
        bitsHigh = 0L
        bitsLow = 0L
        for (i in str.indices) {
            c = str[i].toInt()
            bitPos = 1L shl c
            if (c <= 63 && (bitsLow and bitPos) == 0L) {
                bitsLow = bitsLow or bitPos
                count++
            } else if (c > 63 && (bitsHigh and bitPos) == 0L) {
                bitsHigh = bitsHigh or bitPos
                count++
            }
        }
        println(count)
    }
}