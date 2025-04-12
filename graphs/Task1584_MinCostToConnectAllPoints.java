package graphs;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
// 79%
public class Task1584_MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int sum = 0;

        boolean[] visited = new boolean[n];
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        minHeap.offer(new int[]{0, 0});

        int visits = 0;
        while (visits != n) {
            int[] current = minHeap.poll();
            int elementIndex = current[0];
            int distance = current[1];
            if (visited[elementIndex]) {
                continue;
            }
            visited[elementIndex] = true;
            sum += distance;
            visits++;
            int currentX = points[elementIndex][0];
            int currentY = points[elementIndex][1];
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int[] point = points[i];

                    int x = point[0];
                    int y = point[1];

                    int validDistance = Math.abs(currentX - x) + Math.abs(currentY - y);
                    minHeap.offer(new int[]{i, validDistance});
                }
            }

        }

        return sum;
    }
}