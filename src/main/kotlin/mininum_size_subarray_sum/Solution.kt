package org.example.mininum_size_subarray_sum

import kotlin.math.min

fun main() {
    val arr = intArrayOf(2)
    val solution = Solution()
    println(solution.minSubArrayLen(2, arr))
}

private class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var start = 0
        var end = 0
        var sum = 0
        var minium = Int.MAX_VALUE
        //if (nums.size == 1 && nums[0] == target) return 1
        while (end < nums.size) {
            sum += nums[end]
            while (sum >= target) {
                minium = min(minium, end - start +1)
                sum = sum - nums[start]
                start++
            }
            end++
        }

        return if (minium == Int.MAX_VALUE) 0 else minium
    }
}