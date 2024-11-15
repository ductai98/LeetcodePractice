package org.example.longest_polimdrome_substring

fun main() {
    println(Solution().longestPalindrome("abcd"))
}

private class Solution {
    fun longestPalindrome(s: String): String {
        var result = ""

        if (s.length == 1) return s

        for (i in 0 until s.length) {
            var l = i
            var r = i
            var sub = ArrayDeque<Char>()
            sub.add(s[i])
            while (l - 1 >= 0 && r + 1 < s.length) {
                l--
                r++
                if (s[l] != s[r]) {
                    break
                }
                sub.addFirst(s[l])
                sub.addLast(s[r])
                if (sub.size > result.length) {
                    result = String(sub.toCharArray())
                }
            }
        }

        for (i in 0 until s.length) {
            var l = i
            var r = i+1
            var sub = ArrayDeque<Char>()
            while (l >= 0 && r < s.length) {
                if (s[l] != s[r]) {
                    break
                }
                sub.addFirst(s[l])
                sub.addLast(s[r])
                if (sub.size > result.length) {
                    result = String(sub.toCharArray())
                }
                l--
                r++
            }
        }

        if (result.isNotEmpty()) {
            return result
        }

        return s[0].toString()
    }
}