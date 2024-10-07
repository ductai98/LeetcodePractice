package org.example.maximum_depth_of_binary_tree


fun main() {
    val tree = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15).apply {
                right = TreeNode(11)
            }
            right = TreeNode(7).apply {
                left = TreeNode(12)
                right = TreeNode(13)
            }
        }
    }

    val solution = Solution()
    solution.maxDepth(tree)
}

private class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        // Recursively find the depth of the left and right subtrees
        val leftDepth = maxDepth(root.left)
        val rightDepth = maxDepth(root.right)
        println()
        println("value = ${root.value}")
        println("leftDepth = $leftDepth")
        println("rightDepth = $rightDepth")
        println("max depth = ${1 + maxOf(leftDepth, rightDepth)} ")
        // The maximum depth is 1 (for the current node) + the greater depth of the two subtrees
        return 1 + maxOf(leftDepth, rightDepth)
    }
}

private class TreeNode(val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
