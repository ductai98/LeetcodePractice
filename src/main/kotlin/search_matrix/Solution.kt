package org.example.search_matrix

fun main() {
    val array = arrayOf(
        intArrayOf(1)
    )

    println(Solution().searchMatrix(array, 1))
}

private class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var start = 0
        var end = matrix.size
        val rows = matrix.size
        val cols = matrix[0].size

        while (start <= end) {
            val mid = (start + end) / 2
            if (mid >= rows) {
                return false
            }
            if (target > matrix[mid][cols -1 ]) {
                start = mid + 1
            }else if (target < matrix[mid][0]) {
                end = mid - 1
            } else {
                return searchRow(matrix, target, mid)
            }
        }
        return false
    }

    fun searchRow(matrix: Array<IntArray>, target: Int, row: Int): Boolean {
        var start = 0
        var end = matrix[0].size

        while (start <= end) {
            val mid = (start + end) / 2
            val value = matrix[row][mid]
            if (value == target) {
                return true
            }
            if (value > target) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
        return false
    }
}