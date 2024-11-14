package org.example.construct_quad_tree


fun main() {
    val input = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 0)
    )
    val solution = Solution()
    val result = solution.construct(input)

    println(result)
}

private class Solution {
    fun construct(grid: Array<IntArray>): Node? {
        fun dfs(n: Int, r: Int, c: Int): Node? {
            var sameValue = true
            for (i in 0 until n) {
                for (j in 0 until n) {
                    if (grid[r][c] != grid[r + i][c + j]) {
                        sameValue = false
                        break
                    }
                }
            }

            if (sameValue) {
                return Node(grid[r][c] == 1, true)
            }

            val n = n / 2
            val topLeft = dfs(n, r, c)
            val topRight = dfs(n, r, c + n)
            val bottomLeft = dfs(n, r + n, c)
            val bottomRight = dfs(n, r + n, c + n)
            val node = Node(false, false)
            node.topLeft = topLeft
            node.topRight = topRight
            node.bottomLeft = bottomLeft
            node.bottomRight = bottomRight
            return node
        }

        return dfs(grid.size, 0, 0)
    }
}

private class Node(var `val`: Boolean, var isLeaf: Boolean) {
    var topLeft: Node? = null
    var topRight: Node? = null
    var bottomLeft: Node? = null
    var bottomRight: Node? = null
}