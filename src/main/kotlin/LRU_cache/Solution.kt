package org.example.LRU_cache

fun main() {
    var lruCache = LRUCache(2)
    lruCache.put(2, 1)
    lruCache.put(3, 2)
    println(lruCache.get(3))
    println(lruCache.get(2))
    lruCache.put(4, 3)
    println(lruCache.get(2))
    println(lruCache.get(3))
    println(lruCache.get(4))

}
class ListNode(var value: Int) {
    var next: ListNode? = null
}

class LRUCache(capacity: Int) {
    val cap = capacity
    data class Node(var key: Int, var value: Int) {
        var prev: Node? = null
        var next: Node? = null
    }

    private val head = Node(0, 0)
    private val tail = Node(0, 0)
    private val map = mutableMapOf<Int, Node>()

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        moveToHead(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        val node = map[key]
        if (node != null) {
            node.value = value
            moveToHead(node)
        } else {
            val newNode = Node(key, value)
            map[key] = newNode
            addToHead(newNode)
            if (map.size > cap) {
                val tail = removeTail()
                map.remove(tail.key)
            }
        }
    }

    private fun moveToHead(node: Node) {
        removeNode(node)
        addToHead(node)
    }

    private fun removeNode(node: Node) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }

    private fun addToHead(node: Node) {
        node.prev = head
        node.next = head.next
        head.next?.prev = node
        head.next = node
    }

    private fun removeTail(): Node {
        val node = tail.prev!!
        removeNode(node)
        return node
    }
}