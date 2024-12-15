package LeetCode75.easy;

// 98.9%
public class Task345_ReverseVowelsOfAString {
    public static String reverseVowels(String s) {
        char[] input = s.toCharArray();

        int startIndex = 0;
        int endIndex = s.length() - 1;

        while (true) {


            for (int i = startIndex; i <= endIndex; i++) {
                if (isVowel(input[i])) {
                    startIndex = i;
                    break;
                }
            }
            for (int i = endIndex; i >= startIndex; i--) {
                if (isVowel(input[i]) || i == startIndex) {
                    endIndex = i;
                    break;
                }
            }

            if (startIndex >= endIndex) {
                break;
            } else {
                char temp = input[startIndex];
                input[startIndex] = input[endIndex];
                input[endIndex] = temp;
                startIndex++;
                endIndex--;
            }

        }

        return new String(input);
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U';
    }


}
