package org.example.path_sum

import com.sun.source.tree.Tree

fun main() {
    val tree1 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(3)
            right = TreeNode(4)
        }
        right = TreeNode(5).apply {
            right = TreeNode(6)
        }
    }

    val tree2 = TreeNode(3).apply {
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
    print(solution.hasPathSum(tree1, 6))
}

private class Solution {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) return false
        return dfs(root, 0, targetSum)
    }

    fun dfs(root: TreeNode?, current: Int, targetSum: Int) : Boolean {
        var curr = current
        if (root == null) return false
        curr += root.`val`
        if (root.left == null && root.right == null) {
            return curr == targetSum
        }
        return dfs(root.left, curr, targetSum) || dfs(root.right, curr, targetSum)
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
