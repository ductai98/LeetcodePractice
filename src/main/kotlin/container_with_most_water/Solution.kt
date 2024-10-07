package org.example.container_with_most_water

import kotlin.math.max
import kotlin.math.min

fun main() {
    val arr = intArrayOf(1,1)
    val solution = Solution()
    println(solution.maxArea(arr))
}

private class Solution {
    fun maxArea(height: IntArray): Int {
        var result = 0
        var start = 0
        var end = height.lastIndex

        while (start < end) {
            val distance = end - start
            val area = distance * min(height[start] ,height[end])
            result = max(area, result)
            if (height[start] < height[end]) {
                start++
            } else {
                end--
            }
        }

        return result
    }
}