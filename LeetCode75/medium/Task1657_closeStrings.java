package LeetCode75.medium;

import java.util.*;

//98.9%
public class Task1657_closeStrings {
    public static boolean closeStrings(String word1, String word2) {

        int[] nums1 = new int[26];
        int[] nums2 = new int[26];

        for (char ch : word1.toCharArray()) {
            nums1[ch - 'a']++;
        }
        for (char ch : word2.toCharArray()) {
            nums2[ch - 'a']++;
        }

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] > 0 && nums2[i] <= 0 || nums1[i] <= 0 && nums2[i] > 0) {
                return false;
            }
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        return Arrays.equals(nums1, nums2);
    }
}
