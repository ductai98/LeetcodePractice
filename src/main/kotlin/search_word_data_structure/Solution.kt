package org.example.search_word_data_structure

fun main() {
    val dictionary = WordDictionary()
    dictionary.addWord("at")
    dictionary.addWord("and")
    dictionary.addWord("an")
    dictionary.addWord("add")
    dictionary.addWord("bat")
    println(dictionary.search(".at"))
}

private class WordDictionary() {
    val root = TrieNode()
    fun addWord(word: String) {
        var cur = root
        for (char in word) {
            if (char !in cur.children) {
                cur.children[char] = TrieNode()
            }
            cur = cur.children[char]!!
        }
        cur.isEndOfWord = true
    }

    fun search(word: String, cur: TrieNode = root): Boolean {
        var current = cur
        for (c in word) {
            if (c == '.') {
                if (current.children.isEmpty()) {
                    return false
                }
                current.children.forEach {
                    current = it.value
                    val newWord = word.substring(word.indexOf('.') + 1, word.length)
                    if (search(newWord, current)) return true
                }
                return false
            } else {
                if (c !in current.children) {
                    return false
                }
                current = current.children[c]!!
            }
        }
        if (current.isEndOfWord) {
            return true
        }
        return false
    }

    class TrieNode {
        var isEndOfWord = false
        val children = mutableMapOf<Char, TrieNode>()
    }
}