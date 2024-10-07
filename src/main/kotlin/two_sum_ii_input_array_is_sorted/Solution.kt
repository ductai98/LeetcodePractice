package org.example.two_sum_ii_input_array_is_sorted

fun main() {
    val arr = arrayOf(-1,0).toIntArray()
    val num = -1
    val solution = Solution()
    println(solution.twoSum(arr, num).contentToString())
}

private class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val result = IntArray(2) {0}

        var start = 0
        var end = numbers.lastIndex

        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                result[0] = start + 1
                result[1] = end + 1
                return result
            }
            if (numbers[start] + numbers[end] < target) {
                start++
            }

            if (numbers[start] + numbers[end] > target) {
                end--
            }
        }

        return result
    }
}