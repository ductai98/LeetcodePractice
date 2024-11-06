package org.example.numbers_of_bit_one

fun main() {
    println(Solution().hammingWeight(128))
}

private class Solution {
    fun hammingWeight(n: Int): Int {
        var num = n
        var count = 0
        repeat(32) {
            if (num and 1 == 1) {
                count++
            }
            num = num shr 1
        }
        return count
    }
}