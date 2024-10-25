package org.example.permutations

fun main() {
    val array = intArrayOf(1,2,3)
    val solution = Solution()
    solution.permute(array).forEach {
        println(it)
    }
}

private class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val size = nums.size
        val result = mutableListOf<List<Int>>()
        val arr = Array<Int>(size) {-11}
        fun backtrack(step: Int) {
            if (step == size) {
                result.add(arr.toList())
                return
            }
            for (num in nums) {
                if (arr[step] == -11 && !arr.contains(num)) {
                    arr[step] = num
                    backtrack(step + 1)
                    arr[step] = -11
                }
            }
        }

        backtrack(0)

        return result
    }
}