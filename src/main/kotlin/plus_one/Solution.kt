package org.example.plus_one

fun main() {
    println(Solution().plusOne(intArrayOf(9,9)).contentToString())
}

private class Solution {
    fun plusOne(digits: IntArray): IntArray {
        var index = digits.size - 1
        var carry = 1
        while (index >= 0) {
            val plus = digits[index] + carry
            carry = 0
            if (plus >= 10) {
                carry = 1
                if (index > 0) {
                    digits[index] = plus - 10
                } else {
                    digits[index] = plus - 10
                    val result = ArrayDeque<Int>(digits.toList())
                    result.addFirst(1)
                    return result.toIntArray()
                }
            } else {
                digits[index] = plus
                break
            }
            index--
        }
        return digits
    }
}