package org.example.sum_root_to_leaf_numbers

import com.sun.source.tree.Tree

fun main() {
    val tree1 = TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
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
    print(solution.sumNumbers(tree1))
}

private class Solution {
    var sum = 0
    fun sumNumbers(root: TreeNode?): Int {
        if (root == null) return 0
        dfs(root, "")
        return sum
    }

    fun dfs(root: TreeNode?, current: String) {
        var curr = current
        if (root == null) return
        curr += root.`val`.toString()
        if (root.left == null && root.right == null) {
            sum += curr.toInt()
        }
        dfs(root.left, curr)
        dfs(root.right, curr)
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
