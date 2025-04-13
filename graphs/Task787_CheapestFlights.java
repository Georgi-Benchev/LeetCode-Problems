package graphs;

import java.util.*;

//83%
public class Task787_CheapestFlights {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<int[]>> graph = new ArrayList<>(n);
        int[] minPrice = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            minPrice[i] = Integer.MAX_VALUE;
        }
        minPrice[src] = 0;

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            graph.get(from).add(new int[]{to, price});
        }

        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.offer(new int[]{src, 0, -1});


        while (!bfsQueue.isEmpty()) {
            int[] entry = bfsQueue.poll();
            int airport = entry[0];
            int price = entry[1];
            int stops = entry[2];

            for (int[] nextAirport : graph.get(airport)) {
                int destination = nextAirport[0];
                int newPrice = nextAirport[1] + price;
                if (minPrice[destination] > newPrice && stops < k) {
                    minPrice[destination] = newPrice;
                    bfsQueue.offer(new int[]{destination, newPrice, stops + 1});
                }
            }
        }
        return minPrice[dst] == Integer.MAX_VALUE ? -1 : minPrice[dst];
    }
}