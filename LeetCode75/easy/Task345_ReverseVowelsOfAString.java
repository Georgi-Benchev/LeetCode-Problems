package LeetCode75.easy;
// 98.9%
public class Task345_ReverseVowelsOfAString {
    public static String reverseVowels(String s) {
        char[] input = s.toCharArray();

        int startIndex = 0;
        int endIndex = s.length();

        while (true) {
            while (!isVowel(input[startIndex++])) {
                if (startIndex >= endIndex) {
                    break;
                }
            }
            if (startIndex >= endIndex) {
                break;
            }
            while (!isVowel(input[--endIndex])) {

            }

            char temp = input[startIndex - 1];
            input[startIndex - 1] = input[endIndex];
            input[endIndex] = temp;

        }

        return new String(input);
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U';
    }


}
