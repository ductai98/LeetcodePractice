package org.example.remove_node_from_the_end

fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    node1.next = node2
    /*val node3 = ListNode(3)
    node2.next = node3
    val node10 = ListNode(4)
    node3.next = node10
    val node20 = ListNode(5)
    node10.next = node20*/
    /*val node30 = ListNode(8)
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
    var result = solution.removeNthFromEnd(node1, 2)
    while (result != null) {
        print("${result.value} ->")
        result = result.next
    }
}
private class ListNode(var value: Int) {
    var next: ListNode? = null
}

private class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var size = 0
        var curr = head
        var result : ListNode? = head

        while (curr != null) {
            size++
            curr = curr.next
        }

        if (size == 1) return null

        if (size == n) {
            result = result?.next
            return result
        }

        curr = head
        for (i in 1..(size - n - 1)) {
            curr = curr?.next
        }
        curr?.next = curr?.next?.next

        return result
    }
}