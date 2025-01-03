package easy_tasks;

public class Task35_searchInsert {
    public static int searchInsert(int[] nums, int target) {

        return helper(nums, target, nums.length / 2);
    }


    private static int helper(int[] nums, int target, int start) {

        if ((start == 0 || nums[start - 1] < target) && (nums[start] >= target || start == nums.length - 1)) {
            if (start == nums.length - 1) {
                if (nums[start]>target){
                    return start;
                }else {
                    return start+1;
                }

            } else {
                return start;
            }
        }
        if (nums[start] > target) {
            return helper(nums, target, start / 2);
        } else {
            return helper(nums, target, start + start / 2);
        }
    }
}
