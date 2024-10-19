package org.example.clone_graph

class Node(var `val`: Int) {
    var neighbors: MutableList<Node> = mutableListOf()
}

private class Solution {
    fun cloneGraph(node: Node?): Node? {
        val map = mutableMapOf<Node, Node>()

        fun dfs(node: Node?): Node? {
            if (node == null) return null
            if (map[node] != null) {
                return map[node]
            }
            val newNode = Node(node.`val`)
            map[node] = newNode
            node.neighbors.forEach {
                val copiedNode = dfs(it)
                newNode.neighbors.add(copiedNode ?: Node(-1))
            }
            return newNode
        }

        return dfs(node)
    }
}