package org.example.max_points_on_a_line

fun main() {
    val array = arrayOf(
        intArrayOf(2,3),
        intArrayOf(3,3),
        intArrayOf(-5,3))
    println(Solution().maxPoints(array))
}

private class Solution {
    fun maxPoints(points: Array<IntArray>): Int {
        var result = 1
        var slope: Float = Float.POSITIVE_INFINITY
        for (i in 0 until points.size) {
            val point1 = points[i]
            var count = mutableMapOf<Float, Int>()
            for (j in i + 1 until points.size) {
                val point2 = points[j]
                if (point2[0] == point1[0]) {
                    slope = Float.POSITIVE_INFINITY
                } else {
                    slope = (point2[1].toFloat() - point1[1].toFloat()) / (point2[0].toFloat() - point1[0].toFloat())
                }

                if (point2[1] - point1[1] == 0) {
                    slope = 0f
                }

                if (slope !in count) {
                    count[slope] = 1
                } else {
                    count[slope] = count[slope]!! + 1
                }
                result = maxOf(result, count[slope]!! + 1)
            }
        }

        return result
    }
}