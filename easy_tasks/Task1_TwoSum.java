package easy_tasks;

import java.util.HashMap;
import java.util.Map;

public class Task1_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numbers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (numbers.containsKey(nums[i])) {
                return new int[]{numbers.get(nums[i]), i};
            } else {
                numbers.put(target - nums[i], i);
            }
        }

        return null;
    }
}
