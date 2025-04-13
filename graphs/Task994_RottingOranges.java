package graphs;

import java.util.LinkedList;
import java.util.Queue;
// 70%
public class Task994_RottingOranges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> bfsQueue = new LinkedList<>();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 2) {
                    bfsQueue.offer(new int[]{row, col, 0});
                }
            }
        }

        int finalDepth = 0;
        while (!bfsQueue.isEmpty()) {
            int[] entry = bfsQueue.poll();
            int currentRow = entry[0];
            int currentCol = entry[1];
            int depth = entry[2];

            for (int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1) {
                    grid[newRow][newCol] = 2;
                    bfsQueue.offer(new int[]{newRow, newCol, depth + 1});
                }
            }
            if (bfsQueue.isEmpty()) {
                finalDepth = depth;
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 1) {
                    return -1;
                }
            }
        }

        return finalDepth;
    }
}