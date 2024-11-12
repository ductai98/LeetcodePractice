package org.example.n_queen

fun main() {
    val solution = Solution()
    println(solution.totalNQueens(4))
}

private class Solution {
    fun totalNQueens(n: Int): Int {
        val board = Array(n) { CharArray(n) {'.'} }
        var result = 0
        fun isSafe(row: Int, col: Int): Boolean {
            for (i in 0 until row) {
                if (board[i][col] == 'Q') return false
            }

            var i = row - 1
            var j = col - 1
            while (i >=0 && j >= 0) {
                if (board[i][j] == 'Q') return false
                i--
                j--
            }

            i = row - 1
            j = col + 1
            while (i >=0 && j < n) {
                if (board[i][j] == 'Q') return false
                i--
                j++
            }

            return true
        }

        fun backtrack(r: Int) {
            if (r == n) {
                result++
                return
            }
            for (c in 0 until n) {
                if (isSafe(r, c)) {
                    board[r][c] = 'Q'
                    backtrack(r+1)
                    board[r][c] = '.'
                }
            }
        }

        backtrack(0)

        return result
    }
}