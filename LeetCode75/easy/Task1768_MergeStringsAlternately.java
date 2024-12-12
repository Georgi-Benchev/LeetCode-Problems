package LeetCode75.easy;
//100%
public class Task1768_MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {

        StringBuilder sb = new StringBuilder();
        int min = Math.min(word1.length(), word2.length());
        for (int i = 0; i < min; i++) {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }

        if (word1.length() > word2.length()) {
            sb.append(word1.substring(sb.length() / 2));
        }else {
            sb.append(word2.substring(sb.length() / 2));

        }

        return sb.toString();
    }
}
