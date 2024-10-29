package org.example.maximum_subarray

private class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var result = nums[0]
        var currentMax = 0

        for (num in nums) {
            if (currentMax < 0) {
                currentMax = 0
            }
            currentMax += num
            result = maxOf(result, currentMax)
        }

        return result
    }
}