package org.example.word_search


fun main() {
    val board = arrayOf(
        charArrayOf('A', 'A', 'A', 'A', 'A', 'A'),
        charArrayOf('A', 'A', 'A', 'A', 'A', 'A'),
        charArrayOf('A', 'A', 'A', 'A', 'A', 'A'),
        charArrayOf('A', 'A', 'A', 'A', 'A', 'A'),
        charArrayOf('A', 'A', 'A', 'A', 'A', 'B'),
        charArrayOf('A', 'A', 'A', 'A', 'B', 'A'),
    )
    println(Solution().exist(board, "AAAAAAAAAAAAABB"))
}

class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val rows = board.size
        val cols = board[0].size
        var final = false
        val path = mutableListOf<Char>()
        val direction = listOf(
            1 to 0,
            -1 to 0,
            0 to 1,
            0 to -1
        )

        fun backtrack(r: Int, c: Int, step: Int) {
            if (step == word.length) {
                final = true
                return
            }
            if (r >= rows || c >= cols || r < 0 || c < 0 || board[r][c] == '*' || board[r][c] != word[step]) {
                return
            }

            direction.forEach {
                if (board[r][c] == word[step]) {
                    path.add(board[r][c])
                    board[r][c] = '*'
                    backtrack(r + it.first, c + it.second, step + 1)
                    board[r][c] = path.removeLast()
                }
            }
        }

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (board[i][j] == word[0]) {
                    backtrack(i, j, 0)
                }
            }
        }
        return final
    }
}