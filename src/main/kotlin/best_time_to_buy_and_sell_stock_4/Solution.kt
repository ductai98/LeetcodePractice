package org.example.best_time_to_buy_and_sell_stock_4

private class Solution {
    fun maxProfit(k: Int, prices: IntArray): Int {
        val n = prices.size
        if (n == 0 || k == 0) return 0

        if (k >= n / 2) {
            var profit = 0
            for (i in 1 until n) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1]
                }
            }
            return profit
        }

        val dp = Array(k + 1) { IntArray(n) }

        for (t in 1..k) {
            var maxDiff = -prices[0]
            for (i in 1 until n) {
                dp[t][i] = maxOf(dp[t][i - 1], prices[i] + maxDiff)
                maxDiff = maxOf(maxDiff, dp[t - 1][i] - prices[i])
            }
        }

        return dp[k][n - 1]
    }
}