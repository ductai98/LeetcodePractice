package org.example.same_tree


fun main() {
    /*val tree1 = TreeNode(3).apply {
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
    }*/

    val tree1 = TreeNode(1).apply {
        left = TreeNode(2)
    }

    val tree2 = TreeNode(1).apply {
        right = TreeNode(2)
    }

    val solution = Solution()
    println(solution.isSameTree(tree1, tree2))
}

private class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        if (p == null || q == null) return false
        if (p.`val` != q.`val`) return false

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }
}

private class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
