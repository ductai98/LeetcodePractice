package org.example.minimun_arrow

import kotlin.math.max
import kotlin.math.min

fun main() {
    val arr = arrayOf<IntArray>(
        intArrayOf(1,2),
        intArrayOf(2,3),
        intArrayOf(3,4),
        intArrayOf(4,5)
    )
    val solution = Solution()
    val result = solution.findMinArrowShots(arr)
    println(result)
}

private class Solution {
    //[0,0],[0,0],[4,4],[0,0],[1,3],[5,5],[4,6],[1,1],[0,2]
    fun findMinArrowShots(points: Array<IntArray>): Int {
        if (points.size == 1) return 1
        val sortedPoints = points.sortedBy {
            it[0]
        }
        val size = sortedPoints.size

        var arrow = 0
        var overlap = sortedPoints[0].clone()
        var nextInterval = sortedPoints[1]
        var i = 1
        while(i < size) {
            nextInterval = sortedPoints[i]
            if (nextInterval[0] <= overlap[1]) {
                overlap[0] = max(overlap[0], nextInterval[0])
                overlap[1] = min(overlap[1], nextInterval[1])
            } else {
                arrow++
                overlap = nextInterval
            }
            i++
        }

        return arrow + 1
    }
}