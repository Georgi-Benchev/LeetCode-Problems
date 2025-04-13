package graphs;

import java.util.ArrayList;
import java.util.List;

//75%
public class Task797_AllPathsFromSrcToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();

        int start = 0;
        int end = graph.length - 1;

        dfs(result, new ArrayList<>(), start, end, graph);

        return result;
    }

    private void dfs(List<List<Integer>> history, ArrayList<Integer> tempHistory, int current, int target, int[][] graph) {
        tempHistory.add(current);
        if (target == current) {
            history.add(tempHistory);
            return;
        }

        for (int neighbor : graph[current]) {
            dfs(history, new ArrayList<>(tempHistory), neighbor, target, graph);
        }
    }
}