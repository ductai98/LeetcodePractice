package org.example.partition_list


fun main() {
    val node = ListNode(1).apply {
        next = ListNode(4).apply {
            next = ListNode(3).apply {
                next = ListNode(2).apply {
                    next = ListNode(5).apply {
                        next = ListNode(2)
                    }
                }
            }
        }
    }

    val node1 = ListNode(2).apply {
        next = ListNode(1)
    }

    val solution = Solution()
    var result = solution.partition(node1, 2)
    while (result != null) {
        print("${result.`val`} ->")
        result = result.next
    }
}
private class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

private class Solution {
    fun partition(head: ListNode?, x: Int): ListNode? {
        if (head == null) return null
        if (head.next == null) {
            return head
        }
        var current: ListNode? = head
        var smaller : ListNode? = ListNode(0)
        var pointer1 : ListNode? = smaller
        var bigger : ListNode? = ListNode(0)
        var pointer2 : ListNode? = bigger
        while (current != null) {
            val node = ListNode(current.`val`)
            if (current.`val` < x) {
                pointer1?.next = node
                pointer1 = pointer1?.next
            } else {
                pointer2?.next = node
                pointer2 = pointer2?.next
            }
            current = current.next
        }

        if (smaller?.next == null) {
            return bigger?.next
        }

        if (bigger?.next == null) {
            return smaller?.next
        }

        current = smaller

        while (current?.next != null) {
            current = current.next
        }

        current?.next = bigger.next

        return smaller.next
    }
}