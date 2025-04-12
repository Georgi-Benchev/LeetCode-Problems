package graphs;

import java.util.*;
// beats 20%
public class Task743_NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Map<Integer, Integer> distances = new HashMap<>();

        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] edge : times) {
            int from = edge[0];
            int to = edge[1];
            int dist = edge[2];
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(new int[]{to, dist});
        }
        minHeap.offer(new int[]{k, 0});

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int to = current[0];
            int dist = current[1];
            if (distances.containsKey(to)) {
                continue;
            }
            distances.put(to, dist);

            if (graph.containsKey(to)) {
                for (int[] neighbors : graph.get(to)) {
                    int neighbor = neighbors[0];
                    int distToNeighbor = neighbors[1];
                    if (!distances.containsKey(neighbor)) {
                        minHeap.offer(new int[]{neighbor, dist + distToNeighbor});
                    }
                }
            }
        }

        return distances.size() != n ? -1 : Collections.max(distances.values());
    }
}
