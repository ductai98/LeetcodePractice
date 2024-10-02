package org.example.linked_list_cycle


fun main() {
    val node1 = ListNode(3)
    val node2 = ListNode(2)
    val node3 = ListNode(0)
    val node4 = ListNode(-4)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node2

    val solution = Solution()
    val result = solution.hasCycle(node1)
    println(result)
}
class ListNode(var value: Int) {
      var next: ListNode? = null
}

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        val list = mutableListOf<ListNode>()

        var current = head
        while (current != null) {
            if (list.contains(current)) return true
            list.add(current)
            current = current.next
        }

        return false
    }
}