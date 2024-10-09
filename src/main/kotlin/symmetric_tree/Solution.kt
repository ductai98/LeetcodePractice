package org.example.symmetric_tree

import com.sun.java_cup.internal.runtime.lr_parser


fun main() {
    val tree1 = TreeNode(2).apply {
        left = TreeNode(3).apply {
            left = TreeNode(4)
            right = TreeNode(5).apply {
                left = TreeNode(8)
                right = TreeNode(9)
            }
        }
        right = TreeNode(3).apply {
            left = TreeNode(5).apply {
                left = TreeNode(9)
                right = TreeNode(8)
            }
            right = TreeNode(4)
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
    println(solution.isSymmetric(tree1))
}

private class Solution {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return false
        val left: TreeNode? = root.left
        val right: TreeNode? = root.right
        return isMirror(left, right)
    }

    fun isMirror(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) return true
        if (left == null || right == null) return false
        if (left.`val` != right.`val`) return false
        return isMirror(left.left, right.right) && isMirror(left.right, right.left)
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
