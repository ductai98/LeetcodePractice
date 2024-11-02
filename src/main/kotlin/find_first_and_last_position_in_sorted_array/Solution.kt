package org.example.find_first_and_last_position_in_sorted_array

fun main() {
    val array = intArrayOf(1,1)
    println(Solution().searchRange(array, 1).contentToString())
}

class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val left = binarySearch(nums, target, true)
        val right = binarySearch(nums, target, false)

        return intArrayOf(left, right)
    }

    fun binarySearch(nums: IntArray, target: Int, searchLeft: Boolean): Int {
        var left = 0
        var right = nums.size - 1
        var index = -1
        while (left <= right) {
            val mid = (left + right) / 2

            if (target > nums[mid]) {
                left = mid + 1
            } else if (target < nums[mid]) {
                right = mid - 1
            } else {
                index = mid
                if (searchLeft) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
        }

        return index
    }
}