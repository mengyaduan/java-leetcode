package LcSecond.dfs;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/surrounded-regions/description/">被包围的区域</a>
 **/
public class No130_SurroundedRegions {
    int[][] used;

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if (m == 1 || n == 1) {
            return;
        }
        used = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O' && used[0][i] == 0) {
                used[0][i] = 1;
                dfs(board, m, n, 0, i);
            }
            if (board[m - 1][i] == 'O' && used[m - 1][i] == 0) {
                used[m - 1][i] = 1;
                dfs(board, m, n, m - 1, i);
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O' && used[i][0] == 0) {
                used[i][0] = 1;
                dfs(board, m, n, i, 0);
            }
            if (board[i][n - 1] == 'O' && used[i][n - 1] == 0) {
                used[i][n - 1] = 1;
                dfs(board, m, n, i, n - 1);
            }
        }
        // 最终输出
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && used[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(char[][] board, int m, int n, int i, int j) {
        // up
        if (i - 1 >= 0) {
            dfsItem(board, m, n, i - 1, j);
        }
        // down
        if (i + 1 < m) {
            dfsItem(board, m, n, i + 1, j);
        }
        // left
        if (j - 1 >= 0) {
            dfsItem(board, m, n, i, j - 1);
        }
        // right
        if (j + 1 < n) {
            dfsItem(board, m, n, i, j + 1);
        }
    }
    public void dfsItem(char[][] board, int m, int n, int x, int y) {
        if (board[x][y] == 'O' && used[x][y] == 0) {
            used[x][y] = 1;
            dfs(board, m, n, x, y);
        }
    }

    @Test(description = "")
    public void test3() throws Exception {
        char[][] board = new char[5][5];
        board[0] = new char[]{'O', 'X', 'X', 'O', 'X'};
        board[1] = new char[]{'X', 'O', 'O', 'X', 'O'};
        board[2] = new char[]{'X', 'O', 'X', 'O', 'X'};
        board[3] = new char[]{'O', 'X', 'O', 'O', 'O'};
        board[4] = new char[]{'X', 'X', 'O', 'X', 'O'};
        solve(board);
        showBoard(board);
    }

    @Test(description = "")
    public void tests() throws Exception {
        char[][] board = new char[3][3];
        board[0] = new char[]{'X', 'O', 'X'};
        board[1] = new char[]{'X', 'O', 'X'};
        board[2] = new char[]{'X', 'O', 'X'};
        solve(board);
        showBoard(board);
    }

    @Test(description = "")
    public void test() throws Exception {
        char[][] board = new char[4][4];
        board[0] = new char[]{'X', 'X', 'X', 'X'};
        board[1] = new char[]{'X', 'O', 'O', 'X'};
        board[2] = new char[]{'X', 'X', 'O', 'X'};
        board[3] = new char[]{'X', 'O', 'X', 'X'};
        solve(board);
        showBoard(board);
    }

    public void showBoard(char[][] board) {
        for (char[] item : board) {
            for (char c : item) {
                System.out.print(c + "\t");
            }
            System.out.println();
        }
    }

}

