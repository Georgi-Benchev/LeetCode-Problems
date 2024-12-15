package LeetCode75.medium;
//89%
public class Task238_ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftSide = new int[n];
        int[] rightSide = new int[n];

        leftSide[0] = 1;
        rightSide[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            leftSide[i] = nums[i - 1] * leftSide[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            rightSide[i] = nums[i + 1] * rightSide[i + 1];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = rightSide[i] * leftSide[i];
        }
        return nums;
    }
}
