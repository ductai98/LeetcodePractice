package org.example.reversed_bit

fun main() {
    println(Solution().reverseBits(3))
}

private class Solution {
    fun reverseBits(n: Int): Int {
        var result = 0
        var num = n

        repeat(32) {
            result = (result shl 1) or (num and 1)
            num = num shr 1
        }

        return result
    }
}