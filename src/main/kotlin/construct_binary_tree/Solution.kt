package org.example.construct_binary_tree

fun main() {
    val preorder = intArrayOf(1,2,3)
    val inorder = intArrayOf(3,2,1)

    val solution = Solution()
    TreeNode.printTree(solution.buildTree(preorder, inorder))
}

private class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        var preord = preorder.toMutableList()
        var inord = inorder.toMutableList()
        val first = preord.first()
        var root = TreeNode(first)
        preord.removeFirst()
        val headIndex = inord.indexOf(first)
        inord.removeAt(headIndex)
        val leftIn = mutableListOf<Int>()
        for (i in 0..headIndex - 1) {
            leftIn.add(inord[i])
        }
        for (i in 0..headIndex - 1) {
            inord.removeAt(0)
        }
        val rightIn = inord
        val leftPre = mutableListOf<Int>()
        for (i in 0..leftIn.size - 1) {
            leftPre.add(preord[i])
        }
        for (i in 0..leftIn.size - 1) {
            preord.removeAt(0)
        }
        val rightPre = preord
        if (leftPre.isNotEmpty() && leftIn.isNotEmpty()) {
            root.left = buildTree(leftPre.toIntArray(), leftIn.toIntArray())
        }
        if (rightPre.isNotEmpty() && rightIn.isNotEmpty()) {
            root.right = buildTree(rightPre.toIntArray(), rightIn.toIntArray())
        }

        if (preord.isEmpty() || inord.isEmpty()){
            return root
        }
        return root
    }
}


private class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    companion object {
        fun printTree(head: TreeNode?) {
            if (head == null) return
            println(head.`val`)
            printTree(head.left)
            printTree(head.right)
        }
    }
}
