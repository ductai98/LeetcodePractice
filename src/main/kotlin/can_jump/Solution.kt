package org.example.can_jump

import kotlin.math.max
import kotlin.math.min

fun main() {
    val arr = intArrayOf(2,3,1,1,0,0,0,0,4)
    val solution = Solution()
    println(solution.canJump(arr))
}

class Solution {
    fun canJump(nums: IntArray): Boolean {
        var maxJump = 0
        var i = 0
        while (i < nums.size) {
            if (i > maxJump) return false
            maxJump = max(maxJump, i + nums[i])
            if (maxJump >= nums.size - 1) return true
            i++
        }
        return false
    }
}