package org.example.game_of_life

import kotlin.and
import kotlin.collections.get

fun main() {
    val arr =
        arrayOf(
            intArrayOf(0,1,0),
            intArrayOf(0,0,1),
            intArrayOf(1,1,1),
            intArrayOf(0,0,0))


    val solution = Solution()
    solution.gameOfLife(arr)
}

class Solution {
    fun gameOfLife(board: Array<IntArray>): Unit {
        val rows = board.size
        val cols = board[0].size

        fun countLiveNeighbors(r: Int, c: Int): Int {
            var liveNeighbors = 0
            val directions = arrayOf(
                intArrayOf(-1, -1), intArrayOf(-1, 0), intArrayOf(-1, 1),
                intArrayOf(0, -1),                   intArrayOf(0, 1),
                intArrayOf(1, -1), intArrayOf(1, 0), intArrayOf(1, 1)
            )

            for (dir in directions) {
                val nr = r + dir[0]
                val nc = c + dir[1]
                if (nr in 0 until rows && nc in 0 until cols && board[nr][nc] and 1 == 1) {
                    liveNeighbors++
                }
            }
            return liveNeighbors
        }

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                val liveNeighbors = countLiveNeighbors(r, c)

                if (board[r][c] == 1 && (liveNeighbors == 2 || liveNeighbors == 3)) {

                    board[r][c] = 3
                } else if (board[r][c] == 0 && liveNeighbors == 3) {
                    board[r][c] = 2
                }
            }
        }

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                board[r][c] = board[r][c] shr 1
            }
        }
    }
}