package org.example.triangle

fun main() {
    val triangle = listOf(
        listOf(2),
        listOf(3,4),
        listOf(6,5,7),
        listOf(4,1,8,3)
    )

    println(Solution().minimumTotal(triangle))
}

private class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val array = triangle.map {
            it.toIntArray()
        }.toTypedArray()

        for (i in array.size - 2 downTo 0) {
            for (j in array[i].indices) {
                array[i][j] += minOf(array[i + 1][j], array[i + 1][j + 1])
            }
        }

        return array[0][0]
    }
}