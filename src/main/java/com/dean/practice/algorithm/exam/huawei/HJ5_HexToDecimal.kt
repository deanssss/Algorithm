package com.dean.practice.algorithm.exam.huawei

import java.util.Scanner

// 输入十六进制数转十进制输出
fun main(args: Array<String>) {
    val read = Scanner(System.`in`)
    var numStr: String
    var dec = 0
    var c: Char
    while(read.hasNextLine()) {
        numStr = read.nextLine()
        for (i in (2 until numStr.length)) {
            c = numStr[i]
            dec = dec * 16 + c.hex2dec()
        }
        println(dec)
        dec = 0
    }
}

fun Char.hex2dec(): Int = when(this) {
    '0' -> 0
    '1' -> 1
    '2' -> 2
    '3' -> 3
    '4' -> 4
    '5' -> 5
    '6' -> 6
    '7' -> 7
    '8' -> 8
    '9' -> 9
    'A', 'a' -> 10
    'B', 'b' -> 11
    'C', 'c' -> 12
    'D', 'd' -> 13
    'E', 'e' -> 14
    'F', 'f' -> 15
    else -> error("error")
}