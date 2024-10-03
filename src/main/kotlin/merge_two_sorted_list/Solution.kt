package org.example.merge_two_sorted_list

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
    var result = solution.mergeTwoLists(node1, node4)
    print("${result?.`val`} ->")
    while (result?.next != null) {
        result = result.next
        print("${result?.`val`} ->")
    }
}
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var l1 = list1
        var l2 = list2
        var result = ListNode(-200)
        var currentNode: ListNode? = result
        if (list1 == null && list2 != null) {
            return list2
        }

        if (list1 != null && list2 == null) {
            return list1
        }

        while (l1 != null || l2 != null) {
            if ((l1?.`val` ?: 200) >= (l2?.`val` ?: 200)) {
                val newNode = ListNode(l2!!.`val`)
                currentNode?.next = newNode
                currentNode = currentNode?.next
                l2 = l2.next
            } else {
                val newNode = ListNode(l1!!.`val`)
                currentNode?.next = newNode
                currentNode = currentNode?.next
                l1 = l1.next
            }
        }

        return result.next
    }
}