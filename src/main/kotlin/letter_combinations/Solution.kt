package org.example.letter_combinations

fun main() {
    val solution = Solution()
    solution.letterCombinations("23").forEach {
        println(it)
    }
}

private class Solution {
    val charMap = mutableMapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )
    fun letterCombinations(digits: String) : List<String> {
        val result = mutableListOf<String>()

        fun backtrack(i: Int, curr: String) {
            if (i == digits.length) {
                result.add(curr)
                return
            }

            val str = charMap[digits[i]]!!
            for (c in str) {
                backtrack(i + 1, curr + c)
            }
        }
        backtrack(0, "")
        if (digits.isBlank()) {
            return emptyList()
        }
        return result
    }
}