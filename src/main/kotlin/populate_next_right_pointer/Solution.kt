package org.example.populate_next_right_pointer

import java.util.LinkedList
import java.util.Queue

fun main() {
    val tree = Node(1).apply {
        left = Node(2).apply {
            left = Node(4)
        }
        right = Node(3).apply {
            right = Node(5)
        }
    }

    val solution = Solution()
    val head = solution.connect(tree)
    printNext(head)
}

private class Solution {
    fun connect(root: Node?): Node? {
        if (root == null) return null

        // Initialize a queue for level-order traversal
        val queue: Queue<Node?> = LinkedList()
        queue.add(root)


        while (queue.isNotEmpty()) {

            val levelSize = queue.size
            var prev: Node? = null

            repeat(levelSize) {
                val currentNode = queue.poll()

                if (prev != null) {
                    prev.next = currentNode
                }

                prev = currentNode
                currentNode?.left?.let {
                    queue.add(currentNode.left)
                }
                currentNode?.right?.let {
                    queue.add(currentNode.right)
                }
            }

            prev?.next = null
        }

        return root
    }
}

fun printNext(root: Node?) {
    if (root == null) return
    printNext(root.left)
    println("${root.`val`} -> ${root.next?.`val`}")
    printNext(root.right)
}

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}

