package org.example.number_of_islands

private class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) return 0

        var numIslands = 0
        val rows = grid.size
        val cols = grid[0].size

        fun dfs(r: Int, c: Int) {
            //if out of bounds or already visited (water or visited land), return
            if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') return

            grid[r][c] = '0'

            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)
        }

        // Iterate over each cell in the grid
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] == '1') {
                    numIslands++
                    dfs(r, c)
                }
            }
        }

        return numIslands
    }
}