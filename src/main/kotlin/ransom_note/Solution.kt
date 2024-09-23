package org.example.ransom_note

fun main() {
    val str1 = "a"
    val str2 = "b"
    val solution = Solution()
    println(solution.canConstruct(str1, str2))
}

class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val ransomMap = mutableMapOf<Char, Int>()
        val magazineMap = mutableMapOf<Char, Int>()
        for (i in 0 until ransomNote.length) {
            if (ransomMap.contains(ransomNote[i])) {
                var value = ransomMap[ransomNote[i]] ?: 1
                value++
                ransomMap.put(ransomNote[i], value)
            } else {
                ransomMap.put(ransomNote[i], 1)
            }
        }

        for (i in 0 until magazine.length) {
            if (magazineMap.contains(magazine[i])) {
                var value = magazineMap[magazine[i]] ?: 1
                value++
                magazineMap.put(magazine[i], value)
            } else {
                magazineMap.put(magazine[i], 1)
            }
        }

        for (i in 0 until ransomNote.length) {
            val frequency = ransomMap[ransomNote[i]] ?: 1
            val magazineFre = magazineMap[ransomNote[i]] ?: 0
            if (magazineFre < frequency) {
                return false
            }
        }

        return true
    }
}