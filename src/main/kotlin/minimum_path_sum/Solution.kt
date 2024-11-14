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
        for (i in rows - 1 downTo 0) {
            for (j in cols - 1 downTo 0) {
                if (i + 1 < rows && j + 1 < cols) {
                    grid[i][j] = grid[i][j] + minOf(grid[i+1][j], grid[i][j+1])
                } else if (i+1 < rows) {
                    grid[i][j] = grid[i][j] + grid[i+1][j]
                } else if (j+1 < cols) {
                    grid[i][j] = grid[i][j] + grid[i][j+1]
                }
            }
        }

        return grid[0][0]
    }
}