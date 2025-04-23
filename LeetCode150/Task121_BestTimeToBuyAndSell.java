package LeetCode150;

// 99.8%
public class Task121_BestTimeToBuyAndSell {
    public int maxProfit(int[] prices) {

        int end = 0;
        int bestDiff = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            int current = prices[i];

            if (current > end) {
                end = current;
            } else {
                int temp = end - current;
                if (temp > bestDiff) {
                    bestDiff = temp;
                }
            }
        }
        return bestDiff;
    }
}