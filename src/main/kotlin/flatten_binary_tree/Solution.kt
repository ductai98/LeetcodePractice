package org.example.flatten_binary_tree

import com.sun.source.tree.Tree
import org.example.flatten_binary_tree.TreeNode.Companion.printTree

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
    solution.flatten(tree1)
}

private class Solution {
    val result = TreeNode(0)
    var curr: TreeNode? = result
    fun flatten(root: TreeNode?): Unit {
        curr = makeTree(root)
        root?.left = null
        root?.right = null
        root?.right = curr?.right
        printTree(root)
    }

    fun makeTree(root: TreeNode?) : TreeNode? {
        if (root == null) return null
        curr?.right = TreeNode(root.`val`)
        curr = curr?.right
        makeTree(root.left)
        makeTree(root.right)

        return result.right
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
