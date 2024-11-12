package org.example.word_break

fun main() {
    val s = "cars"
    val wordDict = listOf("car", "ca", "rs")
    println(Solution().wordBreak(s, wordDict))
}

private class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dp = Array<Boolean>(s.length + 1) { false }
        dp[0] = true
        var j = 0
        while (j < s.length) {
            if (dp[j] == true) {
                for (word in wordDict) {
                    val len = word.length
                    if (j + len <= s.length) {
                        val sub = s.substring(j, j+ len)
                        if (sub == word) {
                            dp[j + len] = true
                        }
                    }
                }
            }
            j++
        }

        return dp.last()
    }
}