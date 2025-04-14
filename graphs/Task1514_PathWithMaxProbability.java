package graphs;

import java.util.*;

// 71%
public class Task1514_PathWithMaxProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        List<List<double[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int nodeA = edge[0];
            int nodeB = edge[1];
            double prob = succProb[i];
            graph.get(nodeA).add(new double[]{nodeB, prob});
            graph.get(nodeB).add(new double[]{nodeA, prob});
        }

        double[] bestValues = new double[n];
        bestValues[start_node] = 1;
        Queue<double[]> queue = new LinkedList<>();
        queue.offer(new double[]{start_node, 1});

        while (!queue.isEmpty()) {
            double[] current = queue.poll();
            int node = (int) current[0];
            double probability = current[1];


            for (double[] neighbor : graph.get(node)) {
                int neighborIndex = (int) neighbor[0];
                double neighborProb = neighbor[1] * probability;

                if (neighborProb > bestValues[neighborIndex]) {
                    bestValues[neighborIndex] = neighborProb;
                    queue.offer(new double[]{neighborIndex, neighborProb});
                }
            }
        }

        return bestValues[end_node];
    }
}