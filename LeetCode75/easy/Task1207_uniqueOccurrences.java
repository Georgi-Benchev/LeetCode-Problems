package LeetCode75.easy;

import java.util.*;
//98.7%
public class Task1207_uniqueOccurrences {
    public static boolean uniqueOccurrences(int[] arr) {

        Arrays.sort(arr);
        Set<Integer> uniqueValues = new HashSet<>();

        int currentInt = arr[0];
        int sum = 1;
        int count = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == currentInt) {
                sum++;
            } else {
                uniqueValues.add(sum);
                sum = 1;
                currentInt = arr[i];
                count++;
            }
        }
        uniqueValues.add(sum);
        count++;

        return count == uniqueValues.size();
    }
}
