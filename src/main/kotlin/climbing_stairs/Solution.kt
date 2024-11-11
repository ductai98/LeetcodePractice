package org.example.climbing_stairs

fun main() {
    println(Solution().climbStairs(5))
}

private class Solution {
    fun climbStairs(n: Int): Int {
        val array = Array<Int>(n + 1) {0}

        fun recur(n: Int): Int {
            if (n == 1 || n == 2) {
                array[n-1] = 1
                return 1
            }

            if (array[n-1] != 0) {
                return array[n-1]
            } else {
                val n1 = recur(n-1)
                val n2 = recur(n-2)
                array[n-1] = n1 + n2
                return n1 + n2
            }
        }

        return recur(n+1)
    }
}