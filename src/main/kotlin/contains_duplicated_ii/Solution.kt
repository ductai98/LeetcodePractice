package org.example.contains_duplicated_ii

import kotlin.math.abs

fun main() {
    val arr = intArrayOf(1,2,3,1,2,3)
    val solution = Solution()
    println(solution.containsNearbyDuplicate(arr, 2))
}

private class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = mutableMapOf<Int, Int>()

        for (i in 0 until nums.size){
            if (nums[i] in map &&  abs(map[nums[i]]!! - i) <= k) {
                return true
            }
            map[nums[i]]=i
        }

        return false
    }
}