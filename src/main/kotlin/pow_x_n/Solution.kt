package org.example.pow_x_n

fun main() {
    println(Solution().myPow(2.0, -2147483648))
}

private class Solution {
    fun myPow(x: Double, n: Int): Double {
        var num: Long = n.toLong()
        var result = 0.0
        var isNegative = false

        if (x == 0.0) {
            return x
        }

        if (x == -1.0 || x == 1.0) {
            if (n % 2 == 0) {
                return x * x
            }
            return x
        }

        if (n == -1) {
            return 1 / x
        }

        if (n == 1) {
            return x
        }

        if (n == 0) {
            return 1.0
        }

        if (n > 0) {
            num = n.toLong()
        } else {
            num = -n.toLong()
            isNegative = true
        }

        result = powPositive(x, num)

        if (result.isInfinite()) {
            return 0.0
        }

        if (isNegative) {
            return 1 / result
        }

        return result
    }

    fun powPositive(x: Double, n: Long): Double {
        var num = n
        if (num == 1L) {
            return x
        }

        while (num > 1) {
            if (num % 2 == 0L) {
                num = num / 2
                val res = powPositive(x, num)
                return res*res
            } else {
                num = num / 2
                val res = powPositive(x, num)
                return x * res * res
            }
        }

        return 0.0
    }
}