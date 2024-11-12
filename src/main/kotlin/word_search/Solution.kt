package org.example.word_search


fun main() {
    val board = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E'),
    )
    println(Solution().exist(board, "SEE"))
}

private class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val rows = board.size
        val cols = board[0].size
        val direction = listOf(
            1 to 0,
            -1 to 0,
            0 to 1,
            0 to -1
        )

        fun backtrack(r: Int, c: Int, step: Int) : Boolean {
            if (step == word.length) {
                return true
            }
            if (r >= rows || c >= cols || r < 0 || c < 0 || board[r][c] == '*' || board[r][c] != word[step]) {
                return false
            }

            direction.forEach {
                if (board[r][c] == word[step]) {
                    val temp = board[r][c]
                    board[r][c] = '*'
                    if (backtrack(r + it.first, c + it.second, step + 1)) {
                        return true
                    }
                    board[r][c] = temp
                }
            }

            return false
        }

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (board[i][j] == word[0] && backtrack(i, j, 0)) {
                    return true
                }
            }
        }
        return false
    }
}