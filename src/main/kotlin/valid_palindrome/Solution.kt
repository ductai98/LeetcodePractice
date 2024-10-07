package org.example.valid_palindrome


fun main() {
    val str1 = "A man, a plan, a canal: Panama"
    val solution = Solution()
    println(solution.isPalindrome(str1))
}

private class Solution {
    fun isPalindrome(s: String): Boolean {
        val str = s.replace("[^A-Za-z0-9]".toRegex(), "").lowercase()

        val reverse = str.reversed()

        return str == reverse
    }
}