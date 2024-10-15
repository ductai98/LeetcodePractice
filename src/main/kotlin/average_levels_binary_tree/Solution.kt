package org.example.average_levels_binary_tree

fun main() {
    val tree1 = TreeNode(2147483647).apply {
        left = TreeNode(2147483647)
        right = TreeNode(2147483647)
    }

    val solution = Solution()
    print(solution.averageOfLevels(tree1).contentToString())
}

private class Solution {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val queue = ArrayDeque<TreeNode>()
        val result = mutableListOf<Double>()

        if (root == null) return DoubleArray(0)
        queue.add(root)
        while (queue.isNotEmpty()) {
            val level = queue.size
            var sum : Double = 0.0
            repeat(level) { index ->
                val current = queue.removeFirst()
                sum += current.`val`.toDouble()
                if (index == level - 1) {
                    val average: Double = sum / level
                    result.add(average)
                }
                current.left?.let {
                    queue.add(it)
                }
                current.right?.let {
                    queue.add(it)
                }
            }
        }

        return result.toDoubleArray()
    }
}


private class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
