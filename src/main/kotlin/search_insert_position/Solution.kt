package org.example.search_insert_position

fun main() {
    val solution = Solution()
    println(solution.searchInsert(intArrayOf(1), 1))
}

class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size - 1
        var position = -1
        while (start <= end) {
            val mid = (start + end) / 2

            if (nums[mid] == target) {
                return mid
            }

            if (nums[mid] < target) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }

        for (i in 0 until nums.size) {
            if (nums[i] > target) {
                return i
            }
        }

        if (position == -1) return nums.size

        return position
    }
}