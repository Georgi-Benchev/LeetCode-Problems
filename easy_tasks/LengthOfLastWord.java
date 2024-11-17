package easy_tasks;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] input = s.split(" ");
        return input[input.length - 1].length();

    }
}
