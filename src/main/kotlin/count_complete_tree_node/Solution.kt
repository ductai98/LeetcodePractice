package org.example.count_complete_tree_node

fun main() {
    val tree1 = TreeNode(7).apply {
        left = TreeNode(3)
        right = TreeNode(15).apply {
            left = TreeNode(9)
            right = TreeNode(20)
        }
    }

    val solution = Solution()
    print(solution.countNodes(tree1))
}

private class Solution {
    var count = 0
    fun countNodes(root: TreeNode?): Int {
        if (root == null) return 0
        dfs(root)
        return count
    }

    fun dfs(root: TreeNode?) {
        if (root == null) return
        count++
        dfs(root.left)
        dfs(root.right)
    }
}


private class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
