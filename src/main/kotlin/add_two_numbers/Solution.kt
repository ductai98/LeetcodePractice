package org.example.add_two_numbers


fun main() {
    val node1 = ListNode(5)
    val node2 = ListNode(6)
    node1.next = node2
    /*val node3 = ListNode(9)
    node2.next = node3
    val node10 = ListNode(9)
    node3.next = node10
    val node20 = ListNode(9)
    node10.next = node20
    val node30 = ListNode(9)
    node20.next = node30
    val node11 = ListNode(9)
    node30.next = node11*/

    val node4 = ListNode(5)
    val node5 = ListNode(4)
    node4.next = node5
    val node6 = ListNode(9)
    node5.next = node6
    /*val node7 = ListNode(9)
    node6.next = node7*/

    val solution = Solution()
    var result = solution.addTwoNumbers(node1, node4)
    print("${result?.`val`} ->")
    while (result?.next != null) {
        result = result.next
        print("${result?.`val`} ->")
    }
}
private class ListNode(var `val`: Int) {
      var next: ListNode? = null
}

private class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var list1 = l1
        var list2 = l2
        var li1 = l1
        var li2 = l2
        var firstNum : Int = l1!!.`val` + l2!!.`val`
        var remain : Int = 0
        if (firstNum >= 10) {
            firstNum = firstNum - 10
            remain = 1
        }
        var result: ListNode = ListNode(firstNum)
        val firstNode = result

        var size1 = 1
        while (li1?.next != null) {
            size1++
            li1 = li1.next
        }
        li1 = list1

        var size2 = 1
        while (li2?.next != null) {
            size2++
            li2 = li2.next
        }

        li2 = list2

        if (size1 > size2) {
            val first2 = li2
            while(li1?.next != null) {
                if (li2?.next == null) {
                    val newNode = ListNode(0)
                    li2?.next = newNode
                }
                li2 = li2?.next
                li1 = li1.next
            }
            list2 = first2
        } else if (size1 < size2) {
            val first1 = li1
            while(li2?.next != null) {
                if (li1?.next == null) {
                    val newNode = ListNode(0)
                    li1?.next = newNode
                }
                li1 = li1?.next
                li2 = li2.next
            }
            list1 = first1
        }



        while (list1?.next != null && list2?.next != null) {
            list1 = list1.next
            list2 = list2.next
            firstNum = list1!!.`val` + list2!!.`val` + remain
            if (firstNum >= 10) {
                remain = firstNum / 10
                firstNum = firstNum % 10
            } else {
                remain = 0
            }
            val node = ListNode(firstNum)
            result.next = node
            result = result.next!!
        }
        if (remain != 0) {
            val newNode = ListNode(remain)
            result.next = newNode
        }


        return firstNode
    }
}