package org.example.remove_duplicated_from_sorted_list


fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(1)
    node1.next = node2
    val node3 = ListNode(3)
    node2.next = node3
    val node10 = ListNode(3)
    node3.next = node10
    val node20 = ListNode(4)
    node10.next = node20
    val node30 = ListNode(4)
    node20.next = node30
    val node11 = ListNode(5)
    node30.next = node11
    val node12 = ListNode(6)
    node11.next = node12
    val node13 = ListNode(6)
    node12.next = node13
    val node14 = ListNode(7)
    node13.next = node14

    val solution = Solution()
    var result = solution.deleteDuplicates(node1)
    while (result != null) {
        print("${result.`val`} ->")
        result = result.next
    }
}
private class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

private class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val duplicatedSet = HashSet<Int>()
        var result = ListNode(-200)
        result.next = head

        var current: ListNode? = result
        var pre = current
        current = current?.next

        while (current != null) {
            while (pre?.`val` == current?.`val`) {
                current = current?.next
                duplicatedSet.add(pre?.`val` ?: 500)
            }
            pre?.next = current
            pre = current
            current = current?.next
        }

        current = result
        pre = current
        current = current.next
        while (current != null) {
            while (current?.`val` in duplicatedSet) {
                current = current?.next
            }
            pre?.next = current
            pre = current
            current = current?.next

        }

        return result.next
    }
}