package easy_tasks;

import java.util.ArrayDeque;

public class Task844_Backspace_String_Compare {
    public boolean backspaceCompare(String s, String t) {

        return findEndResult(s).equals(findEndResult(t));
    }

    private String findEndResult(String input) {
        StringBuilder output = new StringBuilder();
        ArrayDeque<Character> charStack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            charStack.push(input.charAt(i));
        }

        int delCount = 0;
        while (!charStack.isEmpty()) {
            char local = charStack.peek();
            if (local == '#') {
                delCount++;
                charStack.pop();
            } else if (delCount != 0) {
                for (int i = 0; i < delCount; i++) {
                    if (charStack.isEmpty()) {
                        break;
                    }
                    char newLocal = charStack.pop();
                    if (newLocal == '#') {
                        delCount += 2;
                    }
                }
                delCount = 0;
            } else {
                output.append(charStack.pop());
            }
        }

        return output.toString();
    }
}