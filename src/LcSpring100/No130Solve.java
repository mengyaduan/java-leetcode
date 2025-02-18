package LcSpring100;


public class No130Solve {

    char o2o = '#';

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        // 标记已经处理过的o
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && (i == 0 || j == 0 || i == m - 1 || j == n - 1)) {
                    // 只有最外围的o需要处理
                    dfs(board, m, n, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == o2o) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int m, int n, int i, int j) {
        // 判断是否越界
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (board[i][j] == 'O') {
            // 首先把当前值改为#，然后搜索四周
            board[i][j] = o2o;
            dfs(board, m, n, i - 1, j);
            dfs(board, m, n, i + 1, j);
            dfs(board, m, n, i, j - 1);
            dfs(board, m, n, i, j + 1);
        }

    }

}

