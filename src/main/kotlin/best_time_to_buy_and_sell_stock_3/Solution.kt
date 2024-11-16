package org.example.best_time_to_buy_and_sell_stock_3

fun main() {
    println(Solution().maxProfit(intArrayOf(3,3,5,0,0,3,1,4)))
}

private class Solution {
    fun maxProfit(prices: IntArray): Int {
        val n = prices.size
        if (n < 2) return 0

        val maxProfitLeft = IntArray(n) {0}
        val maxProfitRight = IntArray(n) {0}

        var minPrice = prices[0]
        for (i in 1 until n) {
            minPrice = minOf(minPrice, prices[i])
            maxProfitLeft[i] = maxOf(maxProfitLeft[i-1], prices[i] - minPrice)
        }

        var maxPrice = prices[n-1]
        for (i in n - 2 downTo 1) {
            maxPrice = maxOf(prices[i], maxPrice)
            maxProfitRight[i] = maxOf(maxProfitRight[i+1], maxPrice - prices[i])
        }

        var profit = 0
        for (i in 0 until n) {
            profit = maxOf(profit, maxProfitLeft[i] + maxProfitRight[i])
        }

        return profit
    }
}