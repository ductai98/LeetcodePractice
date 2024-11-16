package org.example
private val array = intArrayOf(1,2,3,4,5)
fun main() {
    println(maxProfit(array))
}

fun maxProfit(prices: IntArray): Int {
    var profit = 0
    var result = 0
    var min = prices.first()
    var i = 0
    while (i < prices.size) {
        if (prices[i] < min) {
            min = prices[i]
        } else {
            if (prices[i] - min > profit) {
                profit = prices[i] - min
                result += profit
                profit = 0
                min = prices[i]
            }
        }
        i++
    }

    return result
}