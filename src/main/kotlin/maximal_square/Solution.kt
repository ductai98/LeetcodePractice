package org.example.maximal_square

fun main() {
    val matrix = arrayOf(
        charArrayOf('1', '0', '1', '0', '0'),
        charArrayOf('1', '0', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1'),
        charArrayOf('1', '0', '0', '1', '0')
    )

    println(Solution().maximalSquare(matrix))
}

private class Solution {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        val rows = matrix.size
        val cols = matrix[0].size
        var result = 0
        val dp = Array<IntArray>(rows) {
            IntArray(cols) {0}
        }

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j].digitToInt()
                } else if (matrix[i][j] == '0') {
                    dp[i][j] = 0
                } else {
                    dp[i][j] = 1 + minOf(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])
                }

                result = maxOf(result, dp[i][j])
            }
        }

        return result * result
    }
}