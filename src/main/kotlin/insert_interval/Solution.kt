package org.example.insert_interval

import kotlin.math.max

fun main() {
    val arr = arrayOf<IntArray>(
        intArrayOf(2,6),
        intArrayOf(7,9)
    )
    val newArr = intArrayOf(15,18)
    val solution = Solution()
    val result = solution.insert(arr, newArr)
    result.forEach {
        println(it.contentToString())
    }
}

class Solution {
    //[1,2],[3,5],[6,7],[8,10],[12,16]
    //[4,8]
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        var insertIndex = 1
        val result = mutableListOf<IntArray>()
        if (intervals.isEmpty()) {
            result.add(newInterval)
            return result.toTypedArray()
        }
        if (newInterval[0] > intervals.last()[0]) {
            insertIndex = intervals.size
        }
        for (i in 0 until intervals.size) {
            if (newInterval[0] <= intervals[i][0]) {
                insertIndex = i
                break
            }
        }
        for (i in 0 until insertIndex-1) {
            result.add(intervals[i])
        }
        var currentInterval = newInterval
        var i = if (insertIndex > 0) {
            currentInterval = intervals[insertIndex - 1]
            insertIndex - 1
        } else {
            currentInterval = newInterval
            0
        }
        if (currentInterval[1] >= newInterval[0]) {
            currentInterval[1] = max(currentInterval[1], newInterval[1])
        } else {
            result.add(currentInterval)
            currentInterval = newInterval
        }
        var j = i
        while (j < intervals.size) {
            val nextInterval = intervals[j]
            if (currentInterval[1] >= nextInterval[0]) {
                currentInterval[1] = max(currentInterval[1], nextInterval[1])
            } else {
                result.add(currentInterval)
                currentInterval = nextInterval
            }
            j++
        }

        result.add(currentInterval)

        return result.toTypedArray()
    }
}