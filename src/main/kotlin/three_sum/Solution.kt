package org.example.three_sum

fun main() {
    val arr = intArrayOf(-1,0,1,2,-1,-4,-1,-1)
    val solution = Solution()
    println(solution.threeSum(arr))
}

private class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        //[-4,-1,-1,-1,0,1,2]
        val listTriplet = mutableListOf<List<Int>>()
        val triplet = IntArray(3) {0}
        var target = -nums[0]
        for(i in 0..nums.lastIndex) {
            if (i > 0 && nums[i] == nums[i-1]) continue
            target = -nums[i]
            var start = i+1
            var end = nums.lastIndex
            while (start < end) {
                if (start != 0 && nums[start] == nums[start-1] && nums[start] != nums[i]) {
                    start++
                    continue
                }
                if (end != nums.lastIndex && nums[end] == nums[end+1]) {
                    end--
                    continue
                }
                if (nums[start] + nums[end] == target) {
                    triplet[0] = nums[i]
                    triplet[1] = nums[start]
                    triplet[2] = nums[end]
                    listTriplet.add(triplet.toList())
                    start++
                    end--
                } else if (nums[start] + nums[end] < target) {
                    start++
                } else if (nums[start] + nums[end] > target) {
                    end--
                }

            }
        }

        return listTriplet
    }
}