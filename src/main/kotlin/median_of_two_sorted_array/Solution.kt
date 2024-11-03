package org.example.median_of_two_sorted_array

private class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val (A, B) = if (nums1.size <= nums2.size) nums1 to nums2 else nums2 to nums1
        val m = A.size
        val n = B.size
        val totalLength = m + n
        val halfLength = (totalLength + 1) / 2

        var left = 0
        var right = m

        while (left <= right) {
            val partitionA = (left + right) / 2
            val partitionB = halfLength - partitionA

            val maxLeftA = if (partitionA == 0) Int.MIN_VALUE else A[partitionA - 1]
            val minRightA = if (partitionA == m) Int.MAX_VALUE else A[partitionA]

            val maxLeftB = if (partitionB == 0) Int.MIN_VALUE else B[partitionB - 1]
            val minRightB = if (partitionB == n) Int.MAX_VALUE else B[partitionB]

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if (totalLength % 2 != 0) {
                    return maxOf(maxLeftA, maxLeftB).toDouble()
                }
                return (maxOf(maxLeftA, maxLeftB) + minOf(minRightA, minRightB)) / 2.0
            } else if (maxLeftA > minRightB) {
                right = partitionA - 1
            } else {
                left = partitionA + 1
            }
        }

        throw IllegalArgumentException("Input arrays are not sorted or not valid")
    }
}