package org.example.word_ladder

fun main() {
    val begin = "hit"
    val end = "cog"
    val wordList = listOf(
        "hot","dot","dog","lot","log","cog"
    )

    val solution = Solution()
    println(solution.ladderLength(begin, end, wordList))
}

private class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        if (endWord !in wordList) return 0
        val queue = ArrayDeque<Pair<String, Int>>() // word, step
        val visited = mutableSetOf<String>()
        val words = wordList.toSet()
        queue.add(beginWord to 0)
        val alphabet = arrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
        while (queue.isNotEmpty()) {
            val (word, step) = queue.removeFirst()
            if (word == endWord) {
                return step + 1
            }
            for (i in word.indices) {
                val currentWord = word.toCharArray()
                for (entry in alphabet) {
                   if (entry == currentWord[i]) continue
                   currentWord[i] = entry
                   val str = String(currentWord)
                   if (str in words && str !in visited) {
                       queue.add(str to step + 1)
                       visited.add(str)
                   }
                }
            }
        }

        return 0
    }
}