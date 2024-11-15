package org.example.interleaving_string

private class Solution {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        if (s1.length + s2.length != s3.length) return false

        val dp = Array(s1.length + 1) { BooleanArray(s2.length + 1) }
        dp[0][0] = true

        for (i in 0..s1.length) {
            for (j in 0..s2.length) {
                if (i > 0 && s1[i - 1] == s3[i + j - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j]
                }
                if (j > 0 && s2[j - 1] == s3[i + j - 1]) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1]
                }
            }
        }

        return dp[s1.length][s2.length]
    }
}