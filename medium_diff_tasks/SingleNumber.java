package medium_diff_tasks;

public class SingleNumber {
    public int[] singleNumber(int[] nums) {


        int[] result = new int[2];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            boolean check = true;

            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i != j) {
                    check = false;
                    break;
                }
            }
            if (check) {
                result[count] = nums[i];
                if (count == 1) {
                    return result;
                }
                count++;
            }

        }

        return result;
    }
}

/*
Given an integer array nums, in which exactly two elements appear only once
 and all the other elements appear exactly twice. Find the two elements that appear only once.
 You can return the answer in any order.
 */
