package org.example.maximum_sum_circular_subarray

fun main() {
    println(Solution().maxSubarraySumCircular(intArrayOf(-3, -2, -3)))
}

private class Solution {
    fun maxSubarraySumCircular(nums: IntArray): Int {
        var result = 0
        var globalMax = nums[0]
        var currentMax = 0

        var globalMin = nums[0]
        var currentMin = 0
        var total = 0

        for (num in nums) {
            total += num
            currentMax = maxOf(num, currentMax + num)
            globalMax = maxOf(globalMax, currentMax)
            currentMin = minOf(num, currentMin + num)
            globalMin = minOf(globalMin, currentMin)
        }

        if (globalMax < 0) {
            return globalMax
        }

        result = maxOf(globalMax, total - globalMin)

        return result
    }
}