package org.example.merge_intervals

fun main() {
    val arr = arrayOf<IntArray>(
        intArrayOf(0,0),
        intArrayOf(0,0),
        intArrayOf(4,4),
        intArrayOf(0,0),
        intArrayOf(1,3),
        intArrayOf(5,5),
        intArrayOf(4,6),
        intArrayOf(1,1),
        intArrayOf(0,2)
    )
    val solution = Solution()
    val result = solution.merge(arr)
    result.forEach {
        println(it.contentToString())
    }
}

class Solution {
    //[0,0],[0,0],[4,4],[0,0],[1,3],[5,5],[4,6],[1,1],[0,2]
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val intervalsSet = intervals.distinctBy {
            it.toList()
        }
        var result = mutableListOf<IntArray>()
        val checkedSet = mutableSetOf<IntArray>()
        var resultFirst = intervals[0].first()
        var resultLast = intervals[0].last()
        var resultChange = false
        var i = 0
        while (i < intervalsSet.size) {
            if (checkedSet.contains(intervalsSet[i])) {
                i++
                continue
            }
            if (!resultChange) {
                resultFirst = intervalsSet[i].first()
                resultLast = intervalsSet[i].last()
            }
            resultChange = false
            for (j in 0 until intervalsSet.size) {
                if (checkedSet.contains(intervalsSet[j])) continue
                val secondFirst = intervalsSet[j].first()
                val secondLast = intervalsSet[j].last()

                if (secondFirst < resultFirst && secondLast <= resultLast && secondLast >= resultFirst) {
                    resultFirst = secondFirst
                    resultChange = true
                    checkedSet.add(intervalsSet[j])
                } else if (secondFirst >= resultFirst && secondFirst <= resultLast && secondLast > resultLast) {
                    resultLast = secondLast
                    resultChange = true
                    checkedSet.add(intervalsSet[j])
                } else if (secondFirst >= resultFirst && secondLast <= resultLast) {
                    checkedSet.add(intervalsSet[j])
                } else if (secondFirst < resultFirst && secondLast > resultLast) {
                    resultFirst = secondFirst
                    resultLast = secondLast
                    resultChange = true
                    checkedSet.add(intervalsSet[j])
                }
            }
            if (!resultChange || checkedSet.size == intervalsSet.size) {
                result.add(intArrayOf(resultFirst, resultLast))
                i--
            }
            i++
        }
        result.add(intArrayOf(resultFirst, resultLast))
        val final = result.distinctBy {
            it.toList()
        }
        return final.toTypedArray()
    }
}