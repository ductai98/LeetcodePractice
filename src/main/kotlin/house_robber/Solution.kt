package org.example.house_robber

private class Solution {
    fun rob(nums: IntArray): Int {
        var house1 = 0
        var house2 = 0

        for (num in nums) {
            val temp = maxOf(num + house1, house2)
            house1 = house2
            house2 = temp
        }

        return house2
    }
}