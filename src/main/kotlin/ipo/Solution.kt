package org.example.ipo

import java.util.PriorityQueue

fun main() {
    val profits = intArrayOf(1,2,3)
    val capitals = intArrayOf(0,1,1)

    println(Solution().findMaximizedCapital(2,0, profits, capitals))
}

private class Solution {
    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
        val projects = profits.indices.map { i ->
            capital[i] to profits[i]
        }.sortedBy {
            it.first
        }

        val maxHeap = PriorityQueue<Int>(compareByDescending { it })

        var currentCapital = w
        var projectIndex = 0

        repeat(k) {
            while (projectIndex < projects.size && currentCapital >= projects[projectIndex].first) {
                maxHeap.offer(projects[projectIndex].second)
                projectIndex++
            }

            if (maxHeap.isEmpty()) return currentCapital

            currentCapital += maxHeap.poll()
        }

        return currentCapital
    }
}