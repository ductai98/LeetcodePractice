package org.example.add_binary

import kotlin.math.abs

fun main() {
    val a = "11"
    val b = "1"
    println(Solution().addBinary(a,b))
}

private class Solution {
    fun addBinary(a: String, b: String): String {
        var numa = a
        var numb = b
        val lenDif = abs(numa.length - numb.length)
        val len = maxOf(numa.length, numb.length)
        var zeroes = ""
        repeat(lenDif) {
            zeroes += "0"
        }
        if (numa.length < numb.length) {
            numa = zeroes + numa
        } else if (numa.length > numb.length) {
            numb = zeroes + numb
        }
        var i = len - 1
        var result = ArrayDeque<Char>()
        var keep = '0'
        while (i >= 0) {
            val num1 = numa[i]
            val num2 = numb[i]
            val num = StringBuilder().apply {
                append(num1)
                append(num2)
            }.toString()

            when(num) {
                "00" -> {
                    result.addFirst(keep)
                    keep = '0'
                }
                "01", "10" -> {
                    if (keep == '0') {
                        result.addFirst('1')
                    } else {
                        result.addFirst('0')
                    }
                }
                "11" -> {
                    if (keep == '0') {
                        result.addFirst('0')
                        keep = '1'
                    } else {
                        result.addFirst('1')
                    }
                }
            }
            i--
        }
        if (keep != '0') {
            result.addFirst(keep)
        }

        return result.joinToString("")
    }
}