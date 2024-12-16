package LeetCode75.medium;

//95%
public class Task334_IncreasingTriplet {
    public static boolean increasingTriplet(int[] nums) {
        //-1, 1, 0, -3, 3

        int low = nums[0];
        int mid = -1;
        int low2 = -1;

        int temp;
        for (int i = 1; i < nums.length; i++) {
            temp = nums[i];

            if (temp > low) {
                if (mid == -1) {
                    mid = temp;
                    continue;
                }

                if (temp > mid) {
                    return true;
                } else {
                    if (low2 == -1) {
                        mid = temp;
                    } else {
                        low = low2;
                        mid = temp;
                        low2 = -1;
                    }
                }
            } else {
                if (mid == -1) {
                    low = temp;
                } else if (low2 == -1) {
                    low2 = temp;
                } else {
                    if (temp > low2 && temp < mid) {
                        low = low2;
                        mid = temp;
                        low2 = -1;
                    } else {
                        low2 = temp;
                    }
                }
            }
        }

        return false;
    }
}
