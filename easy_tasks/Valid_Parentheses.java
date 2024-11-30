package easy_tasks;

import java.util.ArrayDeque;

public class Valid_Parentheses {
    public boolean isValid(String s) {

        ArrayDeque<Character> openingStack = new ArrayDeque<>();
        if (s.length() % 2 != 0) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            Character local = s.charAt(i);

            if (local.equals('{') || local.equals('(') || local.equals('[')) {
                openingStack.push(local);
            } else {
                if (openingStack.isEmpty()) {
                    return false;
                } else {
                    Character openingLocal = openingStack.pop();
                    if (!openingLocal.equals('(') && local.equals(')')
                            || !openingLocal.equals('{') && local.equals('}')
                            || !openingLocal.equals('[') && local.equals(']')) {
                        return false;
                    }
                }
            }
        }

        return openingStack.isEmpty();
    }
}