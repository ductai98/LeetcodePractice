package org.example.binary_search_tree_iterator

fun main() {
    val tree1 = TreeNode(7).apply {
        left = TreeNode(3)
        right = TreeNode(15).apply {
            left = TreeNode(9)
            right = TreeNode(20)
        }
    }

    val iterator = BSTIterator(tree1)
    iterator.apply {
        println(next())
        println(next())
        println(hasNext())
        println(next())
        println(hasNext())
        println(next())
        println(hasNext())
        println(next())
        println(hasNext())
    }
}

private class BSTIterator(root: TreeNode?) {
    val queue = ArrayDeque<Int>()
    init {
        initInOrder(root)
    }
    fun next(): Int {
        return queue.removeFirst()
    }

    fun hasNext(): Boolean {
        return queue.isNotEmpty()
    }

    fun initInOrder(root: TreeNode?) {
        if (root == null) return
        initInOrder(root.left)
        queue.add(root.`val`)
        initInOrder(root.right)
    }
}


private class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
