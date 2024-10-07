package org.example.reverse_linked_list

fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    node1.next = node2
    val node3 = ListNode(4)
    node2.next = node3
    val node10 = ListNode(5)
    node3.next = node10
    val node20 = ListNode(7)
    node10.next = node20
    val node30 = ListNode(8)
    node20.next = node30
    val node11 = ListNode(9)
    node30.next = node11

    val node4 = null
    /*val node5 = ListNode(3)
    node4.next = node5
    val node6 = ListNode(4)
    node5.next = node6*/
    /*val node7 = ListNode(9)
    node6.next = node7*/

    val solution = Solution()
    var result = solution.reverseList(node1)
    while (result != null) {
        print("${result.`val`} ->")
        result = result.next
    }
}
private class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

private class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var current = head

        if (current?.next == null) return current

        var pre = current
        current = current.next
        pre.next = null

        while (current != null) {
            val next = current.next
            current.next = pre
            pre = current
            current = next
        }

        return pre
    }
}