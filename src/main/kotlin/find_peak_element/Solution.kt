package org.example.find_peak_element

class Solution {
    fun findPeakElement(nums: IntArray): Int {
        var start = 0
        var end = nums.size - 1

        while (start <= end) {
            val mid = (start + end) / 2

             if (mid > 0 && nums[mid] < nums[mid - 1]) {
                 end = mid - 1
             } else if (mid < nums.size - 1 && nums[mid] < nums[mid + 1]) {
                 start = mid + 1
             } else {
                 return mid
             }
        }

        return -1
    }
}