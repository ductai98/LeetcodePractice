package org.example.word_pattern

fun main() {
    val str1 = "aaa"
    val str2 = "aa aa aa aa"
    val solution = Solution()
    println(solution.wordPattern(str1, str2))
}

private class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {
        val mapS = mutableMapOf<Char, String>()
        val mapT = mutableMapOf<String, Char>()
        val str = s.split("\\s+".toRegex())

        if (pattern.length != str.size) return false

        for (i in 0 until pattern.length) {
            if (mapS[pattern[i]] != null && mapS[pattern[i]] != str[i]) {
                return false
            }
            if (mapT[str[i]] != null && mapT[str[i]] != pattern[i]){
                return false
            }
            mapS.put(pattern[i], str[i])
            mapT.put(str[i], pattern[i])
        }

        return true
    }
}