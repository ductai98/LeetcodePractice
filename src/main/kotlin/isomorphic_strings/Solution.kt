package org.example.isomorphic_strings

fun main() {
    val str1 = "badc"
    val str2 = "baba"
    val solution = Solution()
    println(solution.isIsomorphic(str1, str2))
}

class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val mapS = mutableMapOf<Char, Char>()
        val mapT = mutableMapOf<Char, Char>()

        for (i in 0 until s.length) {
            if (mapS[s[i]] != null && mapS[s[i]] != t[i]) return false
            if (mapT[t[i]] != null && mapT[t[i]] != s[i]) return false
            mapS.put(s[i], t[i])
            mapT.put(t[i], s[i])
        }

        if (mapS.size != mapT.size) return false

        return true
    }
}