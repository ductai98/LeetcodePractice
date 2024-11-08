package org.example.palindrome_number

fun main() {
    println(Solution().isPalindrome(-121))
}

class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        var num = x
        var divine = 1

        while (num >= divine * 10) {
            divine = divine * 10
        }

        while (num >= 10) {
            val right = num % 10
            val left = num / divine

            if (left != right) {
                return false
            }

            divine = divine / 10

            num = num % 100
            num = num / 10
        }

        return true
    }
}