package org.example.rotate_list

import java.util.ArrayList

fun main() {
    val node = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }

    val node1 = ListNode(1)

    val solution = Solution()
    var result = solution.rotateRight(node1, 1)
    while (result != null) {
        print("${result.value} ->")
        result = result.next
    }
}
private class ListNode(var value: Int) {
    var next: ListNode? = null
}

private class Solution {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null) return null
        if (head.next == null) {
            return head
        }
        var size = 0
        var result : ListNode? = ListNode(0)
        result?.next = head
        var current : ListNode? = result
        current = current?.next
        while (current != null) {
            size++
            current = current.next
        }
        current = result
        var first = current?.next
        var pre : ListNode? = current
        var time = k % size
        for (i in 1 .. time) {
            while (current?.next != null) {
                pre = current
                current = current.next
            }
            current?.next = first
            first = current
            pre?.next = null
        }
        return first
    }
}