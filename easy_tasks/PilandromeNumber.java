package easy_tasks;

public class PilandromeNumber {
    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        } else {
            String numToString = String.valueOf(x);

            for (int i = 0; i < numToString.length() / 2; i++) {
                if (numToString.charAt(i)!=numToString.charAt(numToString.length()-1-i)){
                    return false;
                }
            }
        }


        return true;
    }
}
/*
Given an integer x, return true if x is a palindrome
, and false otherwise.



        Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
*/
