package lc150;

/**
 * @see <a href="https://leetcode.cn/problems/valid-sudoku/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No36IsValidSudoku {


    public boolean isValidSudoku(char[][] board) {
        int[][] rowNum = new int[9][10];
        int[][] colNum = new int[9][10];
        int[][] matrixNum = new int[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int num = c - '0';
                int matrix = getMatrix(i, j);
                // 检查行、列、阵是否已经包含该数字
                if (rowNum[i][num] == 1 || colNum[j][num] == 1 || matrixNum[matrix][num] == 1) {
                    return false;
                }
                rowNum[i][num] = 1;
                colNum[j][num] = 1;
                matrixNum[matrix][num] = 1;
            }
        }
        return true;
    }

    private int getMatrix(int i, int j) {
        int bigI = i / 3;
        int bigJ = j / 3;
        return bigI + 3 * bigJ;
    }

}
