package LeetCode75.medium;

//86%
public class Task151_ReverseWords {
    public static String reverseWords(String s) {
        String[] input = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = input.length - 1; i >= 1; i--) {

            sb.append(input[i]).append(" ");

        }

        if (input.length > 0) {
            sb.append(input[0]);
        }

        return sb.toString();


    }
}
