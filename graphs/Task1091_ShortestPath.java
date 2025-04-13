package graphs;

import java.util.ArrayDeque;
import java.util.Queue;

// 95%
public class Task1091_ShortestPath {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        int[][] directions = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1},
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };

        Queue<int[]> minHeap = new ArrayDeque<>();
        minHeap.offer(new int[]{0, 0, 1}); // row, col, movesCount
        grid[0][0] = 1;

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int row = current[0];
            int col = current[1];
            int moves = current[2];

            if (row == n - 1 && col == n - 1) {
                return moves;
            }

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                    grid[newRow][newCol] = 1;
                    minHeap.offer(new int[]{newRow, newCol, moves + 1});
                }
            }
        }

        return -1;
    }
}