package org.example.copy_random_list

fun main() {
    val node1 = null
    /*val node2 = ListNode(2)
    node1.next = node2
    val node3 = ListNode(4)
    node2.next = node3*/
    /*val node10 = ListNode(9)
    node3.next = node10
    val node20 = ListNode(9)
    node10.next = node20
    val node30 = ListNode(9)
    node20.next = node30
    val node11 = ListNode(9)
    node30.next = node11*/

    val node4 = null
    /*val node5 = ListNode(3)
    node4.next = node5
    val node6 = ListNode(4)
    node5.next = node6*/
    /*val node7 = ListNode(9)
    node6.next = node7*/

    val solution = Solution()
    var result = solution.copyRandomList(node1)
    print("${result?.`val`} ->")
    while (result?.next != null) {
        result = result.next
        print("${result?.`val`} ->")
    }
}
private class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

private class Solution {
    fun copyRandomList(node: Node?): Node? {
        if (node == null) return null

        // Step 1: Create new nodes and insert them after each original node
        var current = node
        while (current != null) {
            val newNode = Node(current.`val`)
            newNode.next = current.next
            current.next = newNode
            current = newNode.next
        }

        // Step 2: Assign the random pointers for the copied nodes
        current = node
        while (current != null) {
            current.next?.random = current.random?.next
            current = current.next?.next
        }

        // Step 3: Separate the original list from the copied list
        current = node
        val dummyHead = Node(0)
        var copyCurrent: Node? = dummyHead
        while (current != null) {
            copyCurrent?.next = current.next
            current.next = current.next?.next
            current = current.next
            copyCurrent = copyCurrent?.next
        }

        return dummyHead.next
    }
}