package org.example.search_in_sorted_array

fun main() {
    val array = intArrayOf(3,4,5,6,1,2)
    println(Solution().search(array, 2))
}

private class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val mid = (left + right) / 2
            if (nums[mid] == target) {
                return mid
            }
            if (left == right && right == mid) {
                return -1
            }

            if (nums[mid] >= nums[left] && target > nums[mid]) { //mid in left sorted
                left = mid + 1
            } else if (nums[mid] >= nums[left] && target < nums[mid] && target >= nums[left]) {
                right = mid - 1
            } else if (nums[mid] >= nums[left] && target < nums[mid] && target < nums[left]) {
                left = mid + 1
            } else if (nums[mid] < nums[left] && target < nums[mid]) { //mid in right sorted
                right = mid - 1
            } else if (nums[mid] < nums[left] && target > nums[mid] && target <= nums[right]) {
                left = mid + 1
            } else if (nums[mid] < nums[left] && target > nums[mid] && target > nums[right]){
                right = mid - 1
            }
        }
        return -1
    }
}