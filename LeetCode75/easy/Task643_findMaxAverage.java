package LeetCode75.easy;

//99.9%
public class Task643_findMaxAverage {
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int max = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max = sum;

        for (int i = 0; i < nums.length - k; i++) {
            sum = sum - nums[i] + nums[i + k];
            if (sum > max) {
                max = sum;
            }
        }

        return (double) max / k;
    }
}
