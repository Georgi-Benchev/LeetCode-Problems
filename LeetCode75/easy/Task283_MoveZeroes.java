package LeetCode75.easy;

//99.8%
public class Task283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int[] temp = new int[length];
        int indexForZero = length - 1;
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                temp[indexForZero--] = 0;
            } else {
                temp[index++] = nums[i];
            }
        }

        for (int i = 0; i < length; i++) {
            nums[i] = temp[i];
        }
    }
}
