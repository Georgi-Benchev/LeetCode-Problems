package LeetCode75.medium;

import java.util.HashMap;
import java.util.Map;

//99.6%
public class Task2357_equalPairs {
    public static int equalPairs(int[][] grid) {
        int count = 0;
        int size = grid.length;
        Map<Integer, Integer> map = new HashMap<>();

        int hash;
        for (int col = 0; col < size; col++) {
            hash = getHashCodeCols(grid, col);
            map.put(hash, map.getOrDefault(hash, 0) + 1);
        }

        for (int row = 0; row < size; row++) {
            hash = getHashCodeRows(grid[row]);
            if (map.containsKey(hash)) {
                count += map.get(hash);
            }
        }

        return count;
    }

    private static int getHashCodeCols(int[][] grid, int targetCol) {
        int sum = 0;
        for (int row = 0; row < grid.length; row++) {
            sum = grid[row][targetCol] + sum * 5;
        }

        return sum;
    }

    private static int getHashCodeRows(int[] row) {
        int sum = 0;
        for (int i = 0; i < row.length; i++) {
            sum = row[i] + sum * 5;
        }
        return sum;
    }
}
