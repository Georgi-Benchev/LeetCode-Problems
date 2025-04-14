package graphs;

import java.util.ArrayList;
import java.util.List;

// 90%
public class Task207_v3 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] entry : prerequisites) {
            int x = entry[0];
            int y = entry[1];
            graph.get(x).add(y);
        }

        int[] visitations = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visitations[i] == 0) {
                if (dfs(visitations, graph, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int[] visitations, List<List<Integer>> graph, int current) {
        if (visitations[current] == 1) {
            return true;
        } else if (visitations[current] == 2) {
            return false;
        }

        visitations[current] = 1;

        for (int next : graph.get(current)) {
            if (visitations[next] != 2) {
                if (dfs(visitations, graph, next)) {
                    return true;
                }
            }
        }

        visitations[current] = 2;
        return false;
    }
}
