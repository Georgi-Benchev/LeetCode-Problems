package LeetCode75.medium;

//86%
public class Task1004_longestOnes {
    public static int longestOnes(int[] nums, int k) {
        int max = 0;
        int sum = 0;
        int backIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (k >= 0) {
                    sum++;
                } else {
                    while (k <= 0) {
                        if (nums[backIndex++] == 0) {
                            k++;
                        } else {
                            sum--;
                        }
                    }
                }
            } else if (k > 0) {
                sum++;
                k--;

            } else {
                while (nums[backIndex++] == 1) {
                    sum--;
                }
                continue;
            }
            if (sum > max) {
                max = sum;
            }
        }


        return max;
    }
}
