package org.example.minimum_path_sum

fun main() {
    val grid = arrayOf(
        intArrayOf(1,2,3),
        intArrayOf(4,5,6)
    )

    println(Solution().minPathSum(grid))
}

private class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        for (i in 0 until rows) {
            for (j in 0 until cols) {

            }
        }

        return grid[0][0]
    }
}