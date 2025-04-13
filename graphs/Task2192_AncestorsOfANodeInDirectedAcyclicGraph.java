package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 50%
public class Task2192_AncestorsOfANodeInDirectedAcyclicGraph {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {

        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            result.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            graph.get(from).add(to);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(i);
            boolean[] visited = new boolean[n];
            visited[i] = true;
            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int edge : graph.get(current)) {
                    if (!visited[edge]) {
                        visited[edge] = true;
                        queue.offer(edge);
                        result.get(edge).add(i);
                    }
                }
            }
        }

        return result;
    }
}
