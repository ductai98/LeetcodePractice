package org.example.happy_number


fun main() {
    val solution = Solution()
    println(solution.isHappy(2))
}

private class Solution {
    fun isHappy(n: Int): Boolean {
        var str = n.toString()
        var result = 0
        val arr = mutableListOf<Int>()
        while (result != 1) {
            result = 0
            for (i in 0 until str.length) {
                result += (str[i].digitToInt() * str[i].digitToInt())
            }
            if (arr.contains(result)) {
                return false
            } else {
                arr.add(result)
            }
            str = result.toString()
        }
        return true
    }
}