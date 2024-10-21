package org.example.snacks_and_ladders

fun main() {
    val input = arrayOf(
        intArrayOf(-1,-1,-1,-1,-1,-1),
        intArrayOf(-1,-1,-1,-1,-1,-1),
        intArrayOf(-1,-1,-1,-1,-1,-1),
        intArrayOf(-1,35,-1,-1,13,-1),
        intArrayOf(-1,-1,-1,-1,-1,-1),
        intArrayOf(-1,15,-1,-1,-1,-1))

    val solution = Solution()
    println(solution.snakesAndLadders(input))
}

private class Solution {
    fun snakesAndLadders(board: Array<IntArray>): Int {
        val size  = board.size
        board.reverse()
        fun intToPos(square: Int) : Pair<Int, Int> {
            val r = ((square - 1) / size).toInt()
            var c = ((square - 1) % size).toInt()
            if (r % 2 != 0) {
                c = size - 1 - c
            }

            return r to c
        }

        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.add(1 to 0) // [square, move]
        val visited = mutableSetOf<Int>()

        while (queue.isNotEmpty()) {
            val pair = queue.removeFirst()
            val square = pair.first
            val move = pair.second

            for (i in 1..6) {
                var nextSquare = square + i
                val nextPair = intToPos(nextSquare)
                val row = nextPair.first
                val col = nextPair.second
                if (board[row][col] != -1) {
                    nextSquare = board[row][col]
                }

                if (nextSquare == size * size) {
                    return move + 1
                }
                if (nextSquare !in visited) {
                    visited.add(nextSquare)
                    queue.add(nextSquare to move + 1)
                }
            }
        }

        return -1
    }
}