package org.example.mininum_absolute_difference_in_bst

import kotlin.math.abs

fun main() {
    val tree1 = TreeNode(4).apply {
        left = TreeNode(2).apply {
            left = TreeNode(1)
            right = TreeNode(3)
        }
        right = TreeNode(6)
    }

    val solution = Solution()
    println(solution.getMinimumDifference(tree1))
}

private class Solution {
    var min = Int.MAX_VALUE
    var prev = Int.MAX_VALUE
    fun getMinimumDifference(root: TreeNode?): Int {
        dfs(root)
        return min
    }

    fun dfs(root: TreeNode?) {
        if (root == null) return
        dfs(root.left)
        val absValue = abs(root.`val` - prev)
        prev = root.`val`
        min = minOf(absValue, min)
        dfs(root.right)
    }
}


private class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
