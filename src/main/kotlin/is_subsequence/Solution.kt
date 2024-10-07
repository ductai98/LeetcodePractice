package org.example.is_subsequence

fun main() {
    val str1 = "acbc"
    val str2 = "ahcbgdc"
    val solution = Solution()
    println(solution.isSubsequence(str1, str2))
}

private class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        val subSize = s.length
        val parentSize = t.length
        if (subSize > parentSize) return false

        var i = 0
        var j = 0

        while (i < subSize) {
            if (s[i] == t[j]){
                i++
                j++
                if (i >= subSize) return true
                if (j >= parentSize) return false
            }
            if (s[i] != t[j]) {
                j++
                if (j >= parentSize) return false
            }
        }
        return true
    }
}