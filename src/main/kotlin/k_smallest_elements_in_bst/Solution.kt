package org.example.k_smallest_elements_in_bst

fun main() {
    val tree1 = TreeNode(3).apply {
        left = TreeNode(1).apply {
            right = TreeNode(2)
        }
        right = TreeNode(4)
    }

    val solution = Solution()
    println(solution.kthSmallest(tree1, 1))
}

private class Solution {
    var index = 0
    var result = 0
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        dfs(root, k)
        return result
    }
    fun dfs(root: TreeNode?, k: Int) {
        if (root == null) return
        dfs(root.left, k)
        index++
        if (index == k) {
            result = root.`val`
            return
        }
        dfs(root.right, k)
    }
}


private class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
