package org.example.longest_increasing_subsequence

private class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size) { 1 }

        val lis = mutableListOf<Int>()

        for (i in 0 until nums.size) {
            for (j in 0 until i) {
                if (nums[j] < nums[i]) {
                    dp[i] = maxOf(dp[i], dp[j] + 1)
                }
            }
        }

        return dp.max()
    }
}