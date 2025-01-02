package easy_tasks;

public class Task14_longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        String firstStr = strs[0];
        if ("".equals(firstStr)) {
            return "";
        }
        int index = 0;
        boolean flag = true;
        int maxLength = firstStr.length();
        while (maxLength != index && flag) {
            char firstChar = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() <= index || strs[i].charAt(index) != firstChar) {
                    flag = false;
                    break;
                }
            }
            index++;
        }
        if (index == maxLength) {
            return firstStr;
        }

        return firstStr.substring(0, index - 1);


    }
}
