package LeetCode75.medium;

public class Task394_decodeString {
    public static String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder tempString = new StringBuilder();
        StringBuilder tempInt = new StringBuilder();


        for (int i = 0; i < s.length(); i++) {
            tempString.setLength(0);
            tempInt.setLength(0);
            while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                tempInt.append(s.charAt(i));
                i++;
            }
            i++;

            while (i < s.length() && s.charAt(i) != ']') {
                tempString.append(s.charAt(i));
                i++;
            }
            for (int j = 0; j < Integer.parseInt(tempInt.toString()); j++) {
                result.append(tempString);
            }
        }
        return result.toString();
    }
}
