package org.example.valid_anagram

fun main() {
    val str1 = "rat"
    val str2 = "cat"
    val solution = Solution()
    println(solution.isAnagram(str1, str2))
}

class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val mapS = mutableMapOf<Char, Int>()
        val mapT = mutableMapOf<Char, Int>()
        if (s.length != t.length) return false
        for (i in 0 until s.length) {
            if (mapS.contains(s[i])) {
                var value = mapS[s[i]] ?: 1
                value++
                mapS.put(s[i], value)
            } else {
                mapS.put(s[i], 1)
            }
        }

        for (i in 0 until t.length) {
            if (mapT.contains(t[i])) {
                var value = mapT[t[i]] ?: 1
                value++
                mapT.put(t[i], value)
            } else {
                mapT.put(t[i], 1)
            }
        }

        mapT.forEach {
            val char = it.key
            val fre = it.value
            if (mapS[char] == null) return false
            if ((mapS[char] ?: 0) < fre) return false
        }

        return true
    }
}