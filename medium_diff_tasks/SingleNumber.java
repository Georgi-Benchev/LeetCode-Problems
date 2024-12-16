package medium_diff_tasks;
//33% nr 260
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public int[] singleNumber(int[] nums) {

        int[] result = new int[2];
        Map<Integer, Boolean> numbers = new HashMap<>(nums.length);

        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = nums[i];
            if (numbers.containsKey(temp)) {
                numbers.put(temp, false);
            } else {
                numbers.put(temp, true);
            }
        }

        byte position = 0;
        for (Map.Entry<Integer, Boolean> entry : numbers.entrySet()) {
            if (entry.getValue()) {
                result[position++] = entry.getKey();
                if (position == 2) {
                    return result;
                }
            }
        }

        return result;
    }
}

