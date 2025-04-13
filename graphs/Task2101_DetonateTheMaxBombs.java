package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 70%
public class Task2101_DetonateTheMaxBombs {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        int max = 0;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> detonations = new ArrayList<>();

            int[] bomb = bombs[i];
            int x = bomb[0];
            int y = bomb[1];
            int radius = bomb[2];

            for (int j = 0; j < i; j++) {
                int[] possibleExplosion = bombs[j];
                int newX = possibleExplosion[0];
                int newY = possibleExplosion[1];
                double distanceBetweenTwoBombs = Math.sqrt(Math.pow(x - newX, 2) + Math.pow(y - newY, 2));
                if (distanceBetweenTwoBombs <= radius) {
                    detonations.add(j);
                }
            }
            for (int j = i + 1; j < n; j++) {
                int[] possibleExplosion = bombs[j];
                int newX = possibleExplosion[0];
                int newY = possibleExplosion[1];
                double distanceBetweenTwoBombs = Math.sqrt(Math.pow(x - newX, 2) + Math.pow(y - newY, 2));
                if (distanceBetweenTwoBombs <= radius) {
                    detonations.add(j);
                }
            }
            graph.add(detonations);
        }

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            int count = 1;

            Queue<Integer> queue = new LinkedList<>();

            for (int next : graph.get(i)) {
                visited[next] = true;
                queue.offer(next);
                count++;
            }

            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int next : graph.get(current)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                        count++;
                    }
                }
            }

            if (count > max) {
                max = count;
            }
        }

        return max;
    }
}