package org.example.summary_ranges

fun main() {
    val arr = intArrayOf(-2147483648,-2147483647,2147483647)
    val solution = Solution()
    println(solution.summaryRanges(arr))
}

class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        val result = mutableListOf<String>()
        var i = 0
        while (i < nums.size) {
            var str = ""

            var j = 1
            if (nums[i] < Int.MAX_VALUE) {
                while (nums.contains(nums[i] + j)) {
                    j++
                }
            }
            if (j==1) {
                str = "${nums[i]}"
            } else {
                str = "${nums[i]}->${nums[i] + j - 1}"
            }
            i += j
            result.add(str)
        }

        return result
    }
}