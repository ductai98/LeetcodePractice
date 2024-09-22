package org.example.set_matrix_zeroes

fun main() {
    val arr =
        arrayOf(
            intArrayOf(0,1,2,0),
            intArrayOf(3,4,5,2),
            intArrayOf(1,3,1,5))


    val solution = Solution()
    solution.setZeroes(arr)
}

class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val zeroPositions = mutableListOf<Pair<Int, Int>>()
        val rowCount = matrix.size
        val colCount = matrix[0].size
        for (i in 0 until rowCount) {
            for (j in 0 until colCount) {
                if (matrix[i][j] == 0) {
                    zeroPositions.add(i to j)
                }
            }
        }

        if (zeroPositions.isEmpty()) return

        zeroPositions.forEach {
            val row = it.first
            val col = it.second

            for (i in 0 until colCount) {
                matrix[row][i] = 0
            }
            for (i in 0 until rowCount) {
                matrix[i][col] = 0
            }
        }
    }
}