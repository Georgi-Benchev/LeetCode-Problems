package graphs;

import java.util.ArrayList;
import java.util.List;

// beats 92%
public class Task310_MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> level = new ArrayList<>();
        if (n == 1) {
            level.add(0);
            return level;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] connectionsCounter = new int[n];
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            graph.get(x).add(y);
            graph.get(y).add(x);
            connectionsCounter[x]++;
            connectionsCounter[y]++;
        }

        for (int i = 0; i < n; i++) {
            if (connectionsCounter[i] == 1) {
                level.add(i);
            }
        }

        while (true) {
            List<Integer> nextLevel = new ArrayList<>();

            for (int i = 0; i < level.size(); i++) {
                for (int node : graph.get(level.get(i))) {
                    connectionsCounter[node]--;
                    if (connectionsCounter[node] == 1) {
                        nextLevel.add(node);
                    }
                }
            }
            if (nextLevel.isEmpty()) {
                return level;
            } else {
                level = nextLevel;
            }

        }
    }
}