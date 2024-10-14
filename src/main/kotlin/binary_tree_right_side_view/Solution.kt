package org.example.binary_tree_right_side_view

fun main() {
    val tree1 = TreeNode(7).apply {
        left = TreeNode(3).apply {
            left = TreeNode(1).apply {
                left = TreeNode(2)
            }
        }
        right = TreeNode(15).apply {
            left = TreeNode(9)
            right = TreeNode(20)
        }
    }

    val solution = Solution()
    print(solution.rightSideView(tree1))
}

private class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val queue = ArrayDeque<TreeNode>()
        val result = mutableListOf<Int>()

        if (root == null) return emptyList()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val level = queue.size
            repeat(level) { index ->
                val current = queue.removeFirst()
                if (index == level - 1) {
                    result.add(current.`val`)
                }
                current.left?.let {
                    queue.add(it)
                }
                current.right?.let {
                    queue.add(it)
                }
            }
        }

        return result
    }
}


private class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
