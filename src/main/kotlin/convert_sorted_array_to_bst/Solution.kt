package org.example.convert_sorted_array_to_bst

private class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        fun buildRoot(l: Int, r: Int): TreeNode? {
            if (l > r) {
                return null
            }

            val m = ((l + r) / 2 ).toInt()
            val root = TreeNode(nums[m])
            root.left = buildRoot(l, m - 1)
            root.right = buildRoot(m + 1, r)

            return root
        }

        return buildRoot(0, nums.size - 1)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}