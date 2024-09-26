package org.example.two_sum

fun main() {
    val arr = intArrayOf(2,7,11,15)
    val solution = Solution()
    println(solution.twoSum(arr, 9).contentToString())
}

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()

        for (i in 0 until nums.size){
            val comp = target - nums[i]
            if (map.containsKey(comp)){
                return intArrayOf(map[comp]!!, i)
            }
            map[nums[i]]=i
        }

        return intArrayOf()
    }
}