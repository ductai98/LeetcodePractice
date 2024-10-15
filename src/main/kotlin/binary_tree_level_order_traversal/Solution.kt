package org.example.binary_tree_level_order_traversal

fun main() {
    val tree1 = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }

    val solution = Solution()
    solution.levelOrder(tree1).forEach {
        println(it.toString())
    }
}

private class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (root == null) return emptyList()
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val level = queue.size
            val nodes = mutableListOf<Int>()
            repeat(level) {
                val node = queue.removeFirst()

                nodes.add(node.`val`)

                node.left?.let {
                    queue.add(it)
                }

                node.right?.let {
                    queue.add(it)
                }
            }
            result.add(nodes)
        }

        return result
    }
}


private class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
