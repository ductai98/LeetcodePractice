package org.example.coin_change

fun main() {
    println(Solution().coinChange(
        intArrayOf(186,419,83,408),
        6249)
    )
}

private class Solution {
    val max = Int.MAX_VALUE - 1
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { max }
        dp[0] = 0
        var i = 1
        while (i <= amount) {
            for (coin in coins) {
                if (i - coin >= 0) {
                    dp[i] = minOf(dp[i], dp[i - coin] + 1)
                }
            }
            i++
        }

        if (dp[amount] == max) {
            return -1
        }
        return dp[amount]
    }
}