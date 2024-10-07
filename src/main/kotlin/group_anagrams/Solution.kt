package org.example.group_anagrams

fun main() {
    val str1 = arrayOf("","")
    val solution = Solution()
    println(solution.groupAnagrams(str1))
}

private class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        var size = strs.size
        val anagrams = mutableListOf<String>()
        val results = mutableListOf<List<String>>()
        var i = 0
        val checked = mutableSetOf<String>()
        while (i < size) {
            while (i < size && checked.contains(strs[i])) {
                i++
            }
            if (i >= size) break
            anagrams.add(strs[i])
            for (j in i + 1 until size) {
                if (isAnagram(strs[i], strs[j])) {
                    anagrams.add(strs[j])
                    checked.add(strs[j])
                }
            }
            i++
            results.add(anagrams.toList())
            anagrams.clear()
        }

        return results
    }
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