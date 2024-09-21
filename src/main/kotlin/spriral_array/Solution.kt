package org.example.spriral_array

fun main() {
    val arr =
        arrayOf(
            intArrayOf(1,2,3),
            intArrayOf(4,5,6),
            intArrayOf(7,8,9))


    val solution = Solution()
    println(solution.spiralOrder(arr))
}

class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val result = mutableListOf<Int>()

        if (matrix.isEmpty() || matrix[0].isEmpty()) return result

        var top = 0
        var bottom = matrix.size - 1
        var left = 0
        var right = matrix[0].size - 1

        while (top <= bottom && left <= right) {
            // Traverse from left to right on the top row
            for (i in left..right) {
                result.add(matrix[top][i])
            }
            top++

            // Traverse from top to bottom on the right column
            for (i in top..bottom) {
                result.add(matrix[i][right])
            }
            right--

            // Traverse from right to left on the bottom row (if there is a bottom row left)
            if (top <= bottom) {
                for (i in right downTo left) {
                    result.add(matrix[bottom][i])
                }
                bottom--
            }

            // Traverse from bottom to top on the left column (if there is a left column left)
            if (left <= right) {
                for (i in bottom downTo top) {
                    result.add(matrix[i][left])
                }
                left++
            }
        }

        return result
    }
}