package medium_diff_tasks;
// 2679 Sum in a Matrix
public class SumInMatrixTODO {
    public int matrixSum(int[][] nums) {
        int result = 0;

        for (int[] num : nums) {
            result += findBiggest(num);
        }

        return result;
    }

    private int findBiggest(int[] num) {
        int result = 0;
        int biggest = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < num.length; i++) {
            if (num[i] > biggest) {
                if (index != -1) {
                    num[index] = biggest;
                }
                index = i;
                biggest = num[i];
                num[i] = 0;
            }
        }
        return result;
    }
}