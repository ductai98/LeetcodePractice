package org.example.prefix_tree

fun main() {
    val input = arrayOf(
        intArrayOf(-1,-1,-1,-1,-1,-1),
        intArrayOf(-1,-1,-1,-1,-1,-1),
        intArrayOf(-1,-1,-1,-1,-1,-1),
        intArrayOf(-1,35,-1,-1,13,-1),
        intArrayOf(-1,-1,-1,-1,-1,-1),
        intArrayOf(-1,15,-1,-1,-1,-1))

}

class TrieNode {
    var isEndOfWord = false
    val children = mutableMapOf<Char, TrieNode>()
}

private class Trie() {
    val root = TrieNode()

    fun insert(word: String) {
        var cur = root
        for (char in word) {
            if (char !in cur.children) {
                cur.children[char] = TrieNode()
            }
            cur = cur.children[char]!!
        }
        cur.isEndOfWord = true
    }

    fun search(word: String): Boolean {
        var cur = root

        for (c in word) {
            if (c !in cur.children) {
                return false
            }
            cur = cur.children[c]!!
        }
        if (cur.isEndOfWord) {
            return true
        }
        return false
    }

    fun startsWith(prefix: String): Boolean {
        var cur = root
        for (c in prefix) {
            if (c !in cur.children) {
                return false
            }
            cur = cur.children[c]!!
        }
        return true
    }

}