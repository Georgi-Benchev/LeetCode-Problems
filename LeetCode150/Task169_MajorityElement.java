package LeetCode150;

import java.util.HashMap;
import java.util.Map;

public class Task169_MajorityElement {
    public int majorityElement(int[] nums) {
        int target = nums.length / 2;
        Map<Integer, Integer> numbers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            numbers.putIfAbsent(current, 0);
            int currSize = numbers.get(current) + 1;
            if (currSize > target) {
                return current;
            }
            numbers.put(current, currSize);
        }

        return -1;
    }
}
