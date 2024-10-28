package org.example.sort_list

fun main() {
    val node = ListNode(4).apply {
        next = ListNode(2).apply {
            next = ListNode(1).apply {
                next = ListNode(3)
            }
        }
    }
    val solution = Solution()
    var cur = solution.sortList(node)
    while (cur != null) {
        println(cur.`val`)
        cur = cur.next
    }
}

private class ListNode(val `val`: Int) {
    var next: ListNode? = null
}

private class Solution {

    fun sortList(head: ListNode?): ListNode? {
        if (head == null || head.next == null) {
            return head
        }
        var left = head
        var right = getMid(head)
        val temp = right?.next
        right?.next = null
        right = temp

        left = sortList(left)
        right = sortList(right)

        return merge(left, right)
    }

    fun getMid(head: ListNode): ListNode? {
        var slow: ListNode? = head
        var fast: ListNode? = head.next

        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        return slow
    }

    fun merge(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var curr1 = list1
        var curr2 = list2
        var tail: ListNode? = dummy
        while (curr1 != null && curr2 != null) {
            if (curr1.`val` < curr2.`val`) {
                tail?.next = curr1
                curr1 = curr1.next
            } else {
                tail?.next = curr2
                curr2 = curr2.next
            }
            tail = tail?.next
        }
        if (curr1 != null) {
            tail?.next = curr1
        }
        if (curr2 != null) {
            tail?.next = curr2
        }
        return dummy.next
    }
}