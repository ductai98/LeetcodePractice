package org.example.bitwise_and_of_range



private class Solution {
    fun rangeBitwiseAnd(left: Int, right: Int): Int {
        var result = 0
        var l = left
        var r = right
        while (l < r) {
            l = l shr 1
            r = r shr 1
            result ++
        }

        return l shl result
    }
}