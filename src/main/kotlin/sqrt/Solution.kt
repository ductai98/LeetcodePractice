package org.example.sqrt

fun main() {
    println(Solution().mySqrt(2147483646))
}

private class Solution {
    fun mySqrt(x: Int): Int {
        if (x == 2 ) return 1
        var result: Long = 0
        var i: Long = 0L
        while (i <= x) {
            if (i * i == x.toLong()) {
                result = i
                break
            }
            if (i * i > x) {
                result = i - 1
                break
            }
            i++
        }
        return result.toInt()
    }
}