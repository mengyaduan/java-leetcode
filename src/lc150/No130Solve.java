package lc150;

/**
 * @see <a href="https://leetcode.cn/problems/surrounded-regions/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No130Solve {

    int[][] memo;

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        memo = new int[m][n];
        // 遍历四个边，如果是'O'且没操作过，则标记为1，然后DFS
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O' && memo[i][0] == 0) {
                memo[i][0] = 1;
                mark(board, m, n, i, 0);
            }
            if (board[i][n - 1] == 'O' && memo[i][n - 1] == 0) {
                memo[i][n - 1] = 1;
                mark(board, m, n, i, n - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O' && memo[0][i] == 0) {
                memo[0][i] = 1;
                mark(board, m, n, 0, i);
            }
            if (board[m - 1][i] == 'O' && memo[m - 1][i] == 0) {
                memo[m - 1][i] = 1;
                mark(board, m, n, m - 1, i);
            }
        }
        // 四个边都遍历以后，重新过一遍solve，只有标记1的是'O'，其他都是X
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && memo[i][j] != 1) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void mark(char[][] board, int m, int n, int i, int j) {
        int[] xs = new int[]{i - 1, i + 1, i, i};
        int[] ys = new int[]{j, j, j - 1, j + 1};
        for (int k = 0; k < 4; k++) {
            int x = xs[k];
            int y = ys[k];
            if (validXY(m, n, x, y) && board[x][y] == 'O' && memo[x][y] == 0) {
                memo[x][y] = 1;
                mark(board, m, n, x, y);
            }
        }
    }

    /**
     * 校验坐标是否越界
     */
    public boolean validXY(int m, int n, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }


}
