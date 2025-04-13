package LeetCode75.easy;

import java.util.*;

// 76%
public class Task2215_findDifference {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<Integer> resultList1 = new ArrayList<>();
        List<Integer> resultList2 = new ArrayList<>();

        Set<Short> numSet1 = new HashSet<>();
        Set<Short> numSet2 = new HashSet<>();


        for (int i = 0; i < nums1.length; i++) {
            numSet1.add((short) nums1[i]);
        }

        short temp;
        for (int i = 0; i < nums2.length; i++) {
            temp = (short) nums2[i];
            numSet2.add(temp);
            if (!numSet1.contains(temp)) {
                numSet1.add(temp);
                resultList2.add(nums2[i]);
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            temp = (short) nums1[i];
            if (!numSet2.contains(temp)) {
                numSet2.add(temp);
                resultList1.add(nums1[i]);
            }
        }

        return Arrays.asList(resultList1, resultList2);
    }
}
