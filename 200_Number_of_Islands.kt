import java.io.*;
import java.util.*;

// DFS Solution
class Solution {
    fun dfs(grid: Array<CharArray>, r: Int, c: Int) {
        val nr = grid.size
        val nc = grid[0].size

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return
        }

        grid[r][c] = '0'
        dfs(grid, r - 1, c)
        dfs(grid, r + 1, c)
        dfs(grid, r, c - 1)
        dfs(grid, r, c + 1)
    }

    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) {
            return 0
        }

        val nr = grid.size
        val nc = grid[0].size
        var numIslands = 0

        for (r in 0 until nr) {
            for (c in 0 until nc) {
                if (grid[r][c] == '1') {
                    numIslands++
                    dfs(grid, r, c)
                }
            }
        }

        return numIslands
    }
}

Time complexity : O(M×N) where M is the number of rows and N is the number of columns.
Space complexity : worst case O(M×N) in case that the grid map is filled with lands where DFS goes by M×N deep.

// BFS Solution
class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) {
            return 0
        }

        val nr = grid.size
        val nc = grid[0].size
        var numIslands = 0

        for (r in 0 until nr) {
            for (c in 0 until nc) {
                if (grid[r][c] == '1') {
                    numIslands++
                    grid[r][c] = '0' // mark as visited
                    val neighbors: Queue<Int> = LinkedList()
                    // queue is usually a one-dimensional data structure, and it’s often more efficient or simpler to encode 2D coordinates into a single integer to store in the queue.
                    neighbors.add(r * nc + c) // We encode (row, col) as a single integer: row * nc + col

                    while (neighbors.isNotEmpty()) {
                        val id = neighbors.remove()
                        // Decode the cell index back to row and col
                        val row = id / nc
                        val col = id % nc

                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.add((row - 1) * nc + col)
                            grid[row - 1][col] = '0'
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            neighbors.add((row + 1) * nc + col)
                            grid[row + 1][col] = '0'
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.add(row * nc + col - 1)
                            grid[row][col - 1] = '0'
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            neighbors.add(row * nc + col + 1)
                            grid[row][col + 1] = '0'
                        }
                    }
                }
            }
        }

        return numIslands
    }
}

Time complexity : O(M×N) where M is the number of rows and N is the number of columns.
Space complexity : O(min(M,N)) because in worst case where the grid is filled with lands, the size of queue can grow up to min(M,N).

