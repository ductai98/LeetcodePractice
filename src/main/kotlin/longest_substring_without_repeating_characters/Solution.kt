package org.example.longest_substring_without_repeating_characters

import kotlin.math.max

fun main() {
    val str = " a"
    val solution = Solution()
    println(solution.lengthOfLongestSubstring(str))
}

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var substr = ""
        var maxLen = 0
        for (i in 0..s.lastIndex) {
            substr = ""
            for (j in i..s.lastIndex) {
                if (!substr.contains(s[j])) {
                    substr += s[j]
                    maxLen = max(maxLen, substr.length)
                } else {
                    break
                }
            }
        }
        return maxLen
    }
}