package LcSpring100;

public class No289GameOfLife {


    // 0→1
    static int REVIVE = 2;
    // 1→0
    static int DIED = 3;

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int status = statusTrans(board, m, n, i, j);
                if (status > 1) {
                    board[i][j] = status;
                }
            }
        }

        // 更新最终结果
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] == REVIVE ? 1 : board[i][j];
                board[i][j] = board[i][j] == DIED ? 0 : board[i][j];
            }
        }
    }

    private int statusTrans(int[][] board, int m, int n, int i, int j) {
        int countLive = 0;
        if (i - 1 >= 0) {
            // 上
            if (j - 1 >= 0) {
                countLive += isLiveBefore(board, i - 1, j - 1) ? 1 : 0;
            }
            countLive += isLiveBefore(board, i - 1, j) ? 1 : 0;
            if (j + 1 < n) {
                countLive += isLiveBefore(board, i - 1, j + 1) ? 1 : 0;
            }
        }
        // 中
        if (j - 1 >= 0) {
            countLive += isLiveBefore(board, i, j - 1) ? 1 : 0;
        }
        if (j + 1 < n) {
            countLive += isLiveBefore(board, i, j + 1) ? 1 : 0;
        }
        // 下
        if (i + 1 < m) {
            if (j - 1 >= 0) {
                countLive += isLiveBefore(board, i + 1, j - 1) ? 1 : 0;
            }
            countLive += isLiveBefore(board, i + 1, j) ? 1 : 0;
            if (j + 1 < n) {
                countLive += isLiveBefore(board, i + 1, j + 1) ? 1 : 0;
            }
        }
        if (countLive == 3 && board[i][j] == 0) {
            return REVIVE;
        }
        if ((countLive < 2 || countLive > 3) && board[i][j] == 1) {
            return DIED;
        }
        return board[i][j];
    }

    private boolean isLiveBefore(int[][] board, int i, int j) {
        return board[i][j] == 1 || board[i][j] == DIED;
    }

}
