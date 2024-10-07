package org.example.longest_consecutive_sequence

import kotlin.math.max

fun main() {
    val arr = intArrayOf(0,3,7,2,5,8,4,6,0,1)
    val solution = Solution()
    println(solution.longestConsecutive(arr))
}

private class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.size == 0) return 0
        val set = nums.toSet()
        val size = nums.size
        var maxLen = 1
        for(i in 0 until size) {
            var len = 1
            if (!set.contains(nums[i] - 1)) {
                var j = 1
                while ((nums[i] + j) in set) {
                    len++
                    maxLen = max(maxLen, len)
                    j++
                }
            }
        }

        return maxLen
    }
}