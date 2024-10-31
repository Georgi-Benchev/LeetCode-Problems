package medium_diff_tasks;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int count = 1;
        int bestCount = 1;
        for (int i = 0; i < s.length(); i++) {
            List<Character> checkList = new ArrayList<>();

            char target = s.charAt(i);

            for (int j = i + 1; j < s.length(); j++) {

                if (s.charAt(j) != target && !checkList.contains(s.charAt(j))) {
                    checkList.add(s.charAt(j));
                    count++;
                } else {
                    count = 1;
                    break;

                }
                if (count > bestCount) {
                    bestCount = count;
                }

            }

        }

        return bestCount;
    }
}
