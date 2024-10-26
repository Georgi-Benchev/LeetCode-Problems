package medium_diff_tasks;

import java.util.ArrayList;
import java.util.List;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {


        for (int row = 0; row < 9; row++) {
            List<Character> tempList = new ArrayList<>();
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    if (tempList.contains(board[row][col])) {
                        return false;
                    }
                    tempList.add(board[row][col]);
                }
            }
        }
        for (int col = 0; col < 9; col++) {
            List<Character> tempList = new ArrayList<>();
            for (int row = 0; row < 9; row++) {
                if (board[row][col] != '.') {
                    if (tempList.contains(board[row][col])) {
                        return false;
                    }
                    tempList.add(board[row][col]);
                }
            }
        }
        for (int positionRow = 0; positionRow < 9; positionRow += 3) {
            for (int positionCol = 0; positionCol < 9; positionCol += 3) {
                List<Character> tempList = new ArrayList<>();

                for (int row = positionRow; row < 3 + positionRow; row++) {
                    for (int col = positionCol; col < 3 + positionCol; col++) {
                        if (board[row][col] != '.') {
                            if (tempList.contains(board[row][col])) {
                                return false;
                            }
                            tempList.add(board[row][col]);
                        }
                    }
                }
            }
        }
        return true;
    }
}
/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
*/
