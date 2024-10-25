package org.example.combination_sum

fun main() {
    val solution = Solution()
    solution.combinationSum(intArrayOf(2), 1).forEach {
        println(it)
    }
}

private class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        fun backtrack(current: MutableList<Int>, start: Int) {
            if (current.sum() == target) {
                val new = mutableListOf<Int>()
                current.forEach {
                    new.add(it)
                }
                result.add(new)
                return
            }

            for (i in 0 until candidates.size) {
                val num = candidates[i]
                if (current.sum() < target && num >= start) {
                    current.add(num)
                    backtrack(current, num)
                    current.removeLast()
                }
            }
        }

        backtrack(mutableListOf<Int>(), 0)

        return result
    }
}