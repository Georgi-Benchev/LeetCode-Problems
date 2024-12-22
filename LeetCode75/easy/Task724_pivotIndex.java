package LeetCode75.easy;

// 94.7%
public class Task724_pivotIndex {
    public static int pivotIndex(int[] nums) {
        int left = 0;
        int right = 0;
        int[] sumLeft = new int[nums.length];
        int[] sumRight = new int[nums.length];

        int n = nums.length - 1;
        for (int i = 0; i <= n; i++) {
            left += nums[i];
            sumLeft[i] = left;
            right += nums[n - i];
            sumRight[n - i] = right;
        }

        for (int i = 0; i <= n; i++) {
            if (sumLeft[i] == sumRight[i]) {
                return i;
            }
        }


        return -1;
    }
}
