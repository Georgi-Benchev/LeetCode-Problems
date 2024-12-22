package LeetCode75.medium;

import java.util.Arrays;
// 92%
public class Task1679_maxOperations {
    public static int maxOperations(int[] nums, int k) {
        int sum = 0;
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int tempSum = nums[left] + nums[right];

            if (tempSum == k) {
                left++;
                right--;
                sum++;
            } else if (tempSum < k) {
                left++;
            } else {
                right--;
            }
        }


        return sum;
    }
}
