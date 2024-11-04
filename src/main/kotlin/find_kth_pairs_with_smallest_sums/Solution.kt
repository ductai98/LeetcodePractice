package org.example.find_kth_pairs_with_smallest_sums

import java.util.PriorityQueue

fun main() {
    val num1 = intArrayOf(1,1,2)
    val num2 = intArrayOf(1,2,3)
    val k = 6

    val result = Solution().kSmallestPairs(num1, num2, k)
    result.forEach {
        println(it.forEach { e -> print("$e ->") })
    }
}

private class Solution {
    fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (nums1.isEmpty() || nums2.isEmpty() || k == 0) return emptyList()

        val sumQueue = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.first })

        for (i in 0 until minOf(nums2.size, k)) {
            val trip = Triple(nums1[0] + nums2[i], 0, i)
            sumQueue.offer(trip)
        }

        repeat(k) {
            if (sumQueue.isEmpty()) return result
            val (sum, i, j) = sumQueue.poll()

            if (i + 1 < nums1.size) {
                sumQueue.offer(Triple(nums1[i+1] + nums2[j], i + 1, j))
            }
            val list = mutableListOf<Int>().apply {
                add(nums1[i])
                add(nums2[j])
            }
            result.add(list)
        }

        return result
    }
}