package org.example.binary_tree_zigzag_level_order

import com.sun.source.tree.Tree

fun main() {
    val tree1 = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }

    val solution = Solution()
    solution.zigzagLevelOrder(tree1).forEach {
        println(it.toString())
    }
}

private class Solution {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (root == null) return emptyList()
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        var reverse = true
        while (queue.isNotEmpty()) {
            val level = queue.size
            val nodes = mutableListOf<Int>()
            reverse = !reverse
            repeat(level) {
                val node = queue.removeFirst()

                nodes.add(node.`val`)

                node.left?.let {
                    queue.addLast(it)
                }

                node.right?.let {
                    queue.addLast(it)
                }
            }
            if (reverse) {
                nodes.reverse()
                result.add(nodes)
            } else {
                result.add(nodes)
            }
        }

        return result
    }
}


private class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
