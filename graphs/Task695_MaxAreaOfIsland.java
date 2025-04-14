package graphs;

import java.util.LinkedList;
import java.util.Queue;

// 31%
public class Task695_MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 1) {
                    int tempMax = 1;
                    grid[row][col] = 0;

                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{row, col});

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int currentRow = current[0];
                        int currentCol = current[1];

                        for (int[] direction : directions) {
                            int newRow = direction[0] + currentRow;
                            int newCol = direction[1] + currentCol;

                            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1) {
                                grid[newRow][newCol] = 0;
                                queue.offer(new int[]{newRow, newCol});
                                tempMax++;
                            }
                        }
                    }
                    if (tempMax > max) {
                        max = tempMax;
                    }

                }

            }
        }
        return max;

    }
}
