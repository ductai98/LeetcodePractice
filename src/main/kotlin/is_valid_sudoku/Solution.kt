package org.example.is_valid_sudoku

fun main() {
    val arr =
        arrayOf(
            charArrayOf('5','3','.','.','7','.','.','.','.'),
            charArrayOf('6','.','.','1','9','5','.','.','.'),
            charArrayOf('.','9','8','.','.','.','.','6','.'),
            charArrayOf('8','.','.','.','6','.','.','.','3'),
            charArrayOf('4','.','.','8','.','3','.','.','1'),
            charArrayOf('7','.','.','.','2','.','.','.','6'),
            charArrayOf('.','6','.','.','.','.','2','8','.'),
            charArrayOf('.','.','.','4','1','9','.','.','5'),
            charArrayOf('.','.','.','.','8','.','.','7','9'))


    val solution = Solution()
    println(solution.isValidSudoku(arr))
}

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = Array(9) { mutableSetOf<Char>() }
        val cols = Array(9) { mutableSetOf<Char>() }
        val boxes = Array(9) { mutableSetOf<Char>() }

        for (i in 0 until 9) {
            for (j in 0 until 9) {
                val char = board[i][j]
                if (char == '.') continue

                if (char in rows[i]) return false
                rows[i].add(char)

                if (char in cols[j]) return false
                cols[j].add(char)

                val boxIndex = (i / 3) * 3 + (j / 3)
                if (char in boxes[boxIndex]) return false
                boxes[boxIndex].add(char)
            }
        }
        return true
    }
}