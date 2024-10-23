package org.example.word_search_2

import kotlin.contracts.contract

fun main() {
    val board = arrayOf(
        charArrayOf('o', 'a', 'a', 'n'),
        charArrayOf('e', 't', 'a', 'e'),
        charArrayOf('i', 'h', 'k', 'r'),
        charArrayOf('i', 'f', 'l', 'v')
    )

    val words = arrayOf("oath", "pea", "eat", "rain")

    val solution = Solution()
    solution.findWords(board, words).forEach {
        println(it)
    }
}

private class Solution {
    val directions = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, -1),
        intArrayOf(1, 0),
        intArrayOf(-1, 0)
    )

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val result = mutableListOf<String>()
        val trie = Trie()

        for (word in words) {
            trie.insert(word)
        }

        for (i in board.indices) {
            for (j in board[0].indices) {
                dfs(board, i, j, trie.root, result)
            }
        }

        return result
    }

    private fun dfs(board: Array<CharArray>, i: Int, j: Int, node: TrieNode, result: MutableList<String>) {
        if (i < 0 || j < 0 || i >= board.size || j >= board[0].size || board[i][j] == '#') {
            return
        }

        val char = board[i][j]
        val childNode = node.children[char] ?: return

        if (childNode.word != null) {
            result.add(childNode.word!!)
            childNode.word = null
        }

        board[i][j] = '#'

        // Explore all 4 directions
        for (direction in directions) {
            val newRow = i + direction[0]
            val newCol = j + direction[1]
            dfs(board, newRow, newCol, childNode, result)
        }

        board[i][j] = char
    }

    class TrieNode {
        val children = HashMap<Char, TrieNode>()
        var word: String? = null // store the word when it's a valid word
    }

    class Trie {
        val root = TrieNode()

        fun insert(word: String) {
            var node = root
            for (char in word) {
                if (!node.children.containsKey(char)) {
                    node.children[char] = TrieNode()
                }
                node = node.children[char]!!
            }
            node.word = word // mark the end of the word
        }
    }
}