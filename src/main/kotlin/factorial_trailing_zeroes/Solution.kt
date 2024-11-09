package org.example.factorial_trailing_zeroes

private class Solution {
    fun trailingZeroes(n: Int): Int {
        return n / 15625 + n / 3125 + n / 625 + n / 125 + n / 25 + n / 5
    }
}