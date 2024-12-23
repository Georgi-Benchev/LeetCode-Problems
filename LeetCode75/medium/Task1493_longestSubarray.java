package LeetCode75.medium;
//97%
public class Task1493_longestSubarray {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int sum = 0;
        int lastSum = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                sum++;
            } else {
                if (sum + lastSum > max) {
                    max = sum + lastSum;
                }
                lastSum = sum;
                sum = 0;
            }
        }

        if (sum + lastSum > max) {
            max = sum + lastSum;
        }


        return sum;
    }
}
