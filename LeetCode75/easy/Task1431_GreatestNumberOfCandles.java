package LeetCode75.easy;

import java.util.ArrayList;
import java.util.List;

//100%
public class Task1431_GreatestNumberOfCandles {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> returnList = new ArrayList<>(candies.length);
        int max = 0;

        for (int i = 0; i < candies.length; i++) {
            if (max < candies[i]) {
                max = candies[i];
            }
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies > max) {
                returnList.add(true);
            } else {
                returnList.add(false);
            }
        }


        return returnList;
    }
}
