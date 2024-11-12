package org.example.find_minimun_in_rotate_sorted_array

fun main() {
    val array = intArrayOf(1)
    println(Solution().findMin(array))
}

private class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        var mid = -1
        while (left <= right) {
            mid = (left + right) / 2

            if (nums[mid] > nums[right]) {
                left = mid + 1
            } else if (nums[mid] < nums[right]){
                right = mid
            } else {
                return nums[right]
            }
        }
        return nums[mid]
    }
}