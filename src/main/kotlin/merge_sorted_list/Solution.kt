package org.example.merge_sorted_list

fun main() {
    val array = arrayOf<ListNode?>(
        ListNode(-8).apply {
            next = ListNode(-7).apply {
                next = ListNode(-7).apply {
                    next = ListNode(-5).apply {
                        next = ListNode(1).apply {
                            next = ListNode(1).apply {
                                next = ListNode(3).apply {
                                    next = ListNode(4)
                                }
                            }
                        }
                    }
                }
            }
        },
        ListNode(-2),
        ListNode(-10).apply {
            next = ListNode(-10).apply {
                next = ListNode(-7).apply {
                    next = ListNode(0).apply {
                        next = ListNode(1).apply {
                            next = ListNode(3)
                        }
                    }
                }
            }
        },
        ListNode(2)
    )

    val solution = Solution()
    var result = solution.mergeKLists(array)
    while (result != null) {
        print("${result.`val`} -> ")
        result = result.next
    }
}

private class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val notNullList: Array<ListNode?> = lists.filterNotNull().toTypedArray()
        if (notNullList.size == 1) {
            return notNullList[0]
        }
        if (notNullList.isEmpty()) {
            return null
        }
        var list1 = notNullList[0]
        var list2 = notNullList[1]
        var remain = notNullList.copyOfRange(2, notNullList.size)

        val dummy = ListNode(0)
        var head: ListNode? = dummy

        while (list1 != null && list2 != null) {
            if (list1.`val` < list2.`val`) {
                head?.next = list1
                list1 = list1.next
            } else {
                head?.next = list2
                list2 = list2.next
            }
            head = head?.next
        }
        while (list1 != null) {
            head?.next = list1
            list1 = list1.next
            head = head?.next
        }

        while (list2 != null) {
            head?.next = list2
            list2 = list2.next
            head = head?.next
        }
        val newList = arrayOf(dummy.next).plus(remain)
        return mergeKLists(newList)
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}