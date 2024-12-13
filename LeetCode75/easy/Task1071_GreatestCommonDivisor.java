package LeetCode75.easy;
//100%
// solving task nr -> 1071 -> 2/75-Study plan
public class Task1071_GreatestCommonDivisor {
    public static String gcdOfStrings(String str1, String str2) {

        int minLength = Math.min(str1.length(), str2.length());
        int minLengthCopy = minLength;
        int maxLength = Math.max(str1.length(), str2.length());

        while (maxLength != 0) {
            int temp = maxLength;
            maxLength = minLengthCopy % maxLength;
            minLengthCopy = temp;
        }

        int maxDivisor = minLengthCopy;

        if (maxDivisor == 0) {
            return "";
        }

        String base = str1.substring(0, maxDivisor);
        for (int i = 0; i < minLength; i = i + maxDivisor) {
            if (!base.equals(str1.substring(i, i + maxDivisor)) || !base.equals(str2.substring(i, i + maxDivisor))) {
                return "";
            }
        }
        if (str1.length() == minLength) {
            for (int i = minLength; i < str2.length(); i = i + maxDivisor) {
                if (!base.equals(str2.substring(i, i + maxDivisor))) {
                    return "";
                }
            }
        } else {
            for (int i = minLength; i < str1.length(); i = i + maxDivisor) {
                if (!base.equals(str1.substring(i, i + maxDivisor))) {
                    return "";
                }
            }
        }
        return base;
    }
}
