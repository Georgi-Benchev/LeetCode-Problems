package LeetCode75.medium;

//92%
public class Task1456_maxVowels {
    public static int maxVowels(String s, int k) {
        boolean[] results = new boolean[s.length()];


        int sum = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            results[i] = isVowel(s.charAt(i));
            if (i < k && results[i]) {
                sum++;
            }
        }
        max = sum;

        for (int i = 0; i < s.length() - k; i++) {
            if (results[i]) {
                sum--;
            }
            if (results[i + k]) {
                sum++;
            }
            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }

    private static boolean isVowel(char currentChar) {
        return currentChar == 97 || currentChar == 101 || currentChar == 105 || currentChar == 111 || currentChar == 117;
    }
}

