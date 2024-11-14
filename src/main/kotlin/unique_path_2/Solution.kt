package org.example.unique_path_2

fun main() {
    val grid = arrayOf(
        intArrayOf(0,0,0),
        intArrayOf(0,1,0),
        intArrayOf(0,0,0)
    )

    println(Solution().uniquePathsWithObstacles(grid))
}

private class Solution {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val rows = obstacleGrid.size
        val cols = obstacleGrid[0].size
        if (obstacleGrid[0][0] == 1) return 0
        if (obstacleGrid[rows - 1][cols - 1] == 1) return 0
        obstacleGrid[0][0] = 1

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (i == 0 && j == 0) continue
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1
                    continue
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    if (obstacleGrid[i-1][j] > 0 && obstacleGrid[i][j-1] > 0) {
                        obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1]
                    } else if (obstacleGrid[i-1][j] > 0) {
                        obstacleGrid[i][j] = obstacleGrid[i-1][j]
                    } else if (obstacleGrid[i][j-1] > 0) {
                        obstacleGrid[i][j] = obstacleGrid[i][j-1]
                    }
                } else if (i - 1 >= 0) {
                    if (obstacleGrid[i-1][j] > 0) {
                        obstacleGrid[i][j] = obstacleGrid[i-1][j]
                    }
                } else if (j - 1 >= 0) {
                    if (obstacleGrid[i][j-1] > 0) {
                        obstacleGrid[i][j] = obstacleGrid[i][j-1]
                    }
                }
            }
        }

        return obstacleGrid[rows - 1][cols - 1]
    }
}