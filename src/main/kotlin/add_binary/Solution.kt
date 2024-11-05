package org.example.add_binary

import kotlin.math.abs

fun main() {
    val a = "1010"
    val b = "1011"
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
        var result = ""
        var keep = "0"
        while (i >= 0) {
            val num1 = numa[i]
            val num2 = numb[i]
            val num = StringBuilder().apply {
                append(num1)
                append(num2)
            }.toString()

            when(num) {
                "00" -> {
                    result = keep + result
                    keep = "0"
                }
                "01", "10" -> {
                    if (keep == "0") {
                        result = "1$result"
                    } else {
                        result = "0$result"
                    }
                }
                "11" -> {
                    if (keep == "0") {
                        result = "0$result"
                        keep = "1"
                    } else {
                        result = "1$result"
                    }
                }
            }
            i--
        }
        if (keep != "0") {
            result = keep + result
        }

        return result
    }
}