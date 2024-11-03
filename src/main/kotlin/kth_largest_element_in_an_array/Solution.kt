package org.example.kth_largest_element_in_an_array

fun main() {
    val array = intArrayOf(3,2,3,1,2,4,5,5,6)
    println(Solution().findKthLargest(array, 4))
}

private class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        var index = nums.size - k

        fun quickSelect(left: Int, right: Int): Int {
            var pivot = nums[right]
            var p = left
            for (i in left until right) {
                if (nums[i] <= pivot) {
                    val temp = nums[p]
                    nums[p] = nums[i]
                    nums[i] = temp
                    p++
                }
            }
            val temp = nums[p]
            nums[p] = nums[right]
            nums[right] = temp
            if (p > index) {
                return quickSelect(left, p - 1)
            } else if (p < index) {
                return quickSelect(p + 1, right)
            } else {
                return nums[p]
            }
        }

        return quickSelect(0, nums.size - 1)
    }
}