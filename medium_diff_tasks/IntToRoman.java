package medium_diff_tasks;

public class IntToRoman {
    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();
        int thousands = num / 1000;
        for (int i = 0; i < thousands; i++) {
            sb.append("M");
        }
        int hundreds = (num % 1000) / 100;
        int tens = (num % 100) / 10;
        int nums = num % 10;


        if (hundreds == 9) {
            sb.append("CM");
        } else if (hundreds >= 5) {
            sb.append('D');
            for (int i = 0; i < hundreds - 5; i++) {
                sb.append('C');
            }
        } else if (hundreds == 4) {
            sb.append("CD");
        } else {
            for (int i = 0; i < hundreds; i++) {
                sb.append('C');
            }
        }


        if (tens == 9) {
            sb.append("XC");
        } else if (tens >= 5) {
            sb.append('L');
            for (int i = 0; i < tens - 5; i++) {
                sb.append('X');
            }
        } else if (tens == 4) {
            sb.append("XL");
        } else {
            for (int i = 0; i < tens; i++) {
                sb.append('X');
            }
        }

        if (nums == 9) {
            sb.append("IX");
        } else if (nums >= 5) {
            sb.append('V');
            for (int i = 0; i < nums - 5; i++) {
                sb.append('I');
            }
        } else if (nums == 4) {
            sb.append("IV");
        } else {
            for (int i = 0; i < nums; i++) {
                sb.append('I');
            }
        }


        return sb.toString();
    }
}
