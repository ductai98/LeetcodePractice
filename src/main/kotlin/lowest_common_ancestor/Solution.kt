package org.example.lowest_common_ancestor

import com.sun.source.tree.Tree

fun main() {
    val node3 = TreeNode(3)
    val node15 = TreeNode(15)
    val tree1 = TreeNode(7).apply {
        left = node3
        right = node15.apply {
            left = TreeNode(9)
            right = TreeNode(20)
        }
    }

    val solution = Solution()
    print(solution.lowestCommonAncestor(tree1, node3, node15)?.`val`)
}

private class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || root == p || root == q) {
            return root
        }

        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)

        if (left != null && right != null) {
            return root
        }

        return left ?: right
    }
}


private class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
