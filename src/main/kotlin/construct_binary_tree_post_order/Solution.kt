package org.example.construct_binary_tree_post_order

fun main() {
    val postorder = intArrayOf(9,15,7,20,3)
    val inorder = intArrayOf(9,3,15,20,7)

    val solution = Solution()
    TreeNode.printTree(solution.buildTree(inorder, postorder))
}

private class Solution {
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        var postord = postorder.toMutableList()
        var inord = inorder.toMutableList()
        val last = postord.last()
        var root = TreeNode(last)
        postord.removeLast()
        val headIndex = inord.indexOf(last)
        inord.removeAt(headIndex)
        val leftIn = mutableListOf<Int>()
        for (i in 0..headIndex - 1) {
            leftIn.add(inord[i])
        }
        for (i in 0..headIndex - 1) {
            inord.removeAt(0)
        }
        val rightIn = inord
        val leftPost = mutableListOf<Int>()
        for (i in 0..leftIn.size - 1) {
            leftPost.add(postord[i])
        }
        for (i in 0..leftIn.size - 1) {
            postord.removeAt(0)
        }
        val rightPost = postord
        if (leftPost.isNotEmpty() && leftIn.isNotEmpty()) {
            root.left = buildTree(leftIn.toIntArray(), leftPost.toIntArray())
        }
        if (rightPost.isNotEmpty() && rightIn.isNotEmpty()) {
            root.right = buildTree(rightIn.toIntArray(), rightPost.toIntArray())
        }

        if (postord.isEmpty() || inord.isEmpty()){
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
