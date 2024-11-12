package org.example.single_number

fun main() {
    val array = intArrayOf(4,2,2,1,1)
    println(Solution().singleNumber(array))
}

private class Solution {
    fun singleNumber(nums: IntArray): Int {
        var result = 0
        for (num in nums) {
            result = result xor num
        }

        return result
    }
}