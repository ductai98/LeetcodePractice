package org.example.reverse_linked_list_2

fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    node1.next = node2
    val node3 = ListNode(3)
    node2.next = node3
    val node10 = ListNode(4)
    node3.next = node10
    val node20 = ListNode(5)
    node10.next = node20
    val node30 = ListNode(7)
    node20.next = node30
    val node11 = ListNode(8)
    node30.next = node11

    val node4 = null
    /*val node5 = ListNode(3)
    node4.next = node5
    val node6 = ListNode(4)
    node5.next = node6*/
    /*val node7 = ListNode(9)
    node6.next = node7*/

    val solution = Solution()
    var result = solution.reverseBetween(node1, 2 ,4)
    while (result != null) {
        print("${result.`val`} ->")
        result = result.next
    }
}
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        val list = arrayListOf<Int>()
        var current = head
        while (current != null) {
            list.add(current.`val`)
            current = current.next
        }
        var start = left
        var end = right
        while (start < end) {
            val temp = list[start-1]
            list[start-1] = list[end-1]
            list[end-1] = temp
            end--
            start++
        }
        var result = ListNode(0)
        var node: ListNode? = result
        for (i in 0 until list.size) {
            node?.next = ListNode(list[i])
            node = node?.next
        }
         return result.next
    }
}