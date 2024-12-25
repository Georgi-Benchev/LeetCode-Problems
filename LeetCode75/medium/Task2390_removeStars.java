package LeetCode75.medium;

//97%
public class Task2390_removeStars {
    public static String removeStars(String s) {
        char[] input = s.toCharArray();
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            if (input[i] == '*' && index >= 0) {
                index--;
            } else {  // leet**code*
                input[index++] = input[i];
            }
        }

        return new String(input, 0, index);
    }
}
