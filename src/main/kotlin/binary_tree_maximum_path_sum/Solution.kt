package org.example.binary_tree_maximum_path_sum

import kotlin.math.max

fun main() {
    val tree1 = TreeNode(-10).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }

    val tree2 = TreeNode(-3)

    val solution = Solution()
    println(solution.maxPathSum(tree2))
}

private class Solution {
    var sum = Int.MIN_VALUE
    fun maxPathSum(root: TreeNode?): Int {
        if (root == null) return 0
        dfs(root)
        return sum
    }

    fun dfs(root: TreeNode?): Int {
        if (root == null) return 0

        val left = dfs(root.left)
        val leftMax = max(left, 0)
        val right = dfs(root.right)
        val rightMax = max(right, 0)

        sum = max(sum, root.`val` + leftMax + rightMax)

        return root.`val` + max(leftMax, rightMax)
    }
}


private class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    companion object {
        fun printTree(head: TreeNode?) {
            if (head == null) return
            println(head.`val`)
            printTree(head.left)
            printTree(head.right)
        }
    }
}
