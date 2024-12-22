package LeetCode75.medium;
// 98.9%
public class Task11_maxArea {
    public static int maxArea(int[] height) {
        int max = 0;

        int left = height[0];
        int indexLeft = 0;
        int right = height[height.length - 1];
        int indexRight = height.length - 1;
        max = Math.min(left, right) * (indexRight - indexLeft);


        int brakeCheck = indexRight;
        while (brakeCheck > 1) {
            if (left < right) {
                for (int i = indexLeft + 1; i < indexRight; i++) {
                    brakeCheck--;
                    if (height[i] > left) {
                        left = height[i];
                        indexLeft = i;
                        if (max < Math.min(left, right) * (indexRight - i)) {
                            max = Math.min(left, right) * (indexRight - i);
                        }
                        if (left > right) {
                            break;
                        }
                    }
                }
            } else {
                for (int i = indexRight - 1; i >= indexLeft; i--) {
                    brakeCheck--;
                    if (height[i] > right) {
                        right = height[i];
                        indexRight = i;
                        if (max < Math.min(left, right) * (i - indexLeft)) {
                            max = Math.min(left, right) * (i - indexLeft);
                        }
                        if (right > left) {
                            break;
                        }
                    }
                }
            }
        }


        return max;
    }
}
