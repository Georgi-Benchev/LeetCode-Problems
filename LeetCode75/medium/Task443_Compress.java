package LeetCode75.medium;

//99,6%
public class Task443_Compress {
    public static int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();

        int counter = 0;
        char tempChar = chars[0];
        for (int i = 0; i < chars.length; i++) {
            char local = chars[i];
            if (local == tempChar) {
                counter++;
            } else {
                if (counter == 1) {
                    sb.append(tempChar);
                    tempChar = local;
                    counter = 1;
                } else {
                    sb.append(tempChar);
                    sb.append(counter);
                    tempChar = local;
                    counter = 1;
                }
            }
        }

        if (counter == 1) {
            sb.append(tempChar);
        } else {
            sb.append(tempChar);
            sb.append(counter);
        }

        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }

        return sb.length();
    }
}
