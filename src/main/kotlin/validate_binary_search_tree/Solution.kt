package org.example.validate_binary_search_tree

fun main() {
    val tree1 = TreeNode(2147483647)

    val solution = Solution()
    println(solution.isValidBST(tree1))
}

private class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) return true

        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    fun isValid(root: TreeNode?, min: Long, max: Long): Boolean {
        if (root == null) return true

        val validLeft = isValid(root.left, min, root.`val`.toLong())

        if (root.`val` <= min || root.`val` >= max) return false

        val validRight = isValid(root.right, root.`val`.toLong(), max)

        return validLeft && validRight

    }
}


private class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
