package lc150;

import org.testng.annotations.Test;

import static DataStruct.tools.createMatrix;
import static DataStruct.tools.showMatrix;

/**
 * @see <a href="https://leetcode.cn/problems/game-of-life/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No289GameOfLife {

    int REVIVAL = 2;
    int DIED = 3;

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = countLive(board, m, n, i, j);
                if (board[i][j] == 0) {
                    // 本身是死的，只需要考虑是否复活
                    if (live == 3) {
                        board[i][j] = REVIVAL;
                    }
                } else {
                    // 本身是活的，可能会死
                    if (live < 2 || live > 3) {
                        board[i][j] = DIED;
                    }
                }
            }
        }
        showMatrix(board);

        // 遍历，将Revival置为1， 将died置为0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == REVIVAL) {
                    board[i][j] = 1;
                }
                if (board[i][j] == DIED) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private int countLive(int[][] board, int m, int n, int i, int j) {
        int res = 0;
        if (i - 1 >= 0 && j - 1 >= 0) {
            res += (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == DIED) ? 1 : 0;
        }
        if (i - 1 >= 0) {
            res += (board[i - 1][j] == 1 || board[i - 1][j] == DIED) ? 1 : 0;
        }
        if (i - 1 >= 0 && j + 1 < n) {
            res += (board[i-1][j + 1] == 1 || board[i-1][j + 1] == DIED) ? 1 : 0;
        }
        if (j - 1 >= 0) {
            res += (board[i][j - 1] == 1 || board[i][j - 1] == DIED) ? 1 : 0;
        }
        if (j + 1 < n) {
            res += (board[i][j + 1] == 1 || board[i][j + 1] == DIED) ? 1 : 0;
        }
        if (i + 1 < m && j - 1 >= 0) {
            res += (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == DIED) ? 1 : 0;
        }
        if (i + 1 < m) {
            res += (board[i + 1][j] == 1 || board[i + 1][j] == DIED) ? 1 : 0;
        }
        if (i + 1 < m && j + 1 < n) {
            res += (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == DIED) ? 1 : 0;
        }
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        int[][] matrix = createMatrix(4, 3, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0);
        gameOfLife(matrix);
        showMatrix(matrix);


    }

}
