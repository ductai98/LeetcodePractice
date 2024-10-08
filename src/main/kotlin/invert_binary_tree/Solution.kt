package org.example.invert_binary_tree


fun main() {
    val tree1 = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15).apply {
                right = TreeNode(11)
            }
            right = TreeNode(7).apply {
                left = TreeNode(12)
                right = TreeNode(13)
            }
        }
    }

    val tree2 = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15).apply {
                right = TreeNode(11)
            }
            right = TreeNode(7).apply {
                left = TreeNode(12)
                right = TreeNode(13)
            }
        }
    }

    /*val tree1 = TreeNode(1).apply {
        left = TreeNode(2)
    }

    val tree2 = TreeNode(1).apply {
        right = TreeNode(2)
    }*/

    val solution = Solution()
    TreeNode.printTree(solution.invertTree(tree1))
}

private class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val temp = TreeNode(0).apply {
            left = root.left
        }
        root.left = root.right

        root.right = temp.left

        invertTree(root.left)
        invertTree(root.right)
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
