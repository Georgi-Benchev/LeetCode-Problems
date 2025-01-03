package easy_tasks;

//100%
public class Task26_removeDuplicates {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int temp = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != temp) {
                temp = nums[i];
                nums[count] = temp;
                count++;
            }
        }
        return count;
    }
}