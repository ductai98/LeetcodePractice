package org.example.rotate_image

fun main() {
    val arr =
        arrayOf(
            intArrayOf(1,2,3),
            intArrayOf(4,5,6),
            intArrayOf(7,8,9))


    val solution = Solution()
    solution.rotate(arr)
}

class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        val size = matrix.size
        for (i in 0 until size) {
            for (j in i + 1 until size) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }

        for (i in 0 until size) {
            for (j in 0 until size / 2) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[i][size - 1 - j]
                matrix[i][size - 1 - j] = temp
            }
        }
        matrix.forEach {
            println(it.contentToString())
        }
    }
}