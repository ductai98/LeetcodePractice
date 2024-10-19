package org.example.surrounded_regions

private class Solution {
    fun solve(board: Array<CharArray>): Unit {
        if (board.isEmpty()) return
        val rows = board.size
        val cols = board[0].size
        fun dfs(r: Int, c: Int) {
            if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] != 'O') return
            board[r][c] = '*'
            val direction = arrayOf(
                1 to 0,
                -1 to 0,
                0 to 1,
                0 to -1
            )
            direction.forEach {
                dfs(r+it.first, c+it.second)
            }
        }

        for (r in 0..rows-1) {
            for (c in 0..cols-1) {
                if ((r == 0 || c == 0 || r == rows -1 || c == cols - 1) && board[r][c] == 'O') {
                    dfs(r, c)
                }
            }
        }

        for (r in 0..rows-1) {
            for (c in 0..cols-1) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X'
                }
                if (board[r][c] == '*') {
                    board[r][c] = 'O'
                }
            }
        }
    }
}