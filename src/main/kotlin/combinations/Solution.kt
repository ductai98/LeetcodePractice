package org.example.combinations

fun main() {
    val solution = Solution()
    solution.combine(4, 3).forEach {
        println(it)
    }
}

private class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val arr = Array<Int>(k) {-1}
        fun backtrack(step: Int, start: Int) {
            if (step == k) {
                result.add(arr.toList())
                return
            }
            for (num in 1..n) {
                if (num > start) {
                    arr[step] = num
                    backtrack(step + 1, num)
                }
            }
        }

        backtrack(0, 0)

        return result
    }
}