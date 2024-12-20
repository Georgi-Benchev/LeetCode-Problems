package LeetCode75.easy;
//100%
public class Task392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {

        char[] charsSmall = s.toCharArray();
        char[] charsBig = t.toCharArray();
        byte pointerS = 0;

        if (charsSmall.length == 0) {
            return true;
        }
        for (int i = 0; i < charsBig.length; i++) {
            if (charsBig[i] == charsSmall[pointerS]) {
                pointerS++;
                if (pointerS == charsSmall.length) {
                    return true;
                }
            }
        }

        return false;
    }
}
