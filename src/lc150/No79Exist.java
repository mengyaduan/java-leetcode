package lc150;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.cn/problems/word-search/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No79Exist {

    int[][] helper;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        helper = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean res = backtrack(board, m, n, i, j, word, 0);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int m, int n, int i, int j, String word, int idx) {
        if (idx == word.length() - 1) {
            return board[i][j] == word.charAt(idx);
        }
        if (board[i][j] != word.charAt(idx)) {
            return false;
        }
        helper[i][j] = 1;
        // 如果当前位置相等，继续四面八方找
        int[] xs = new int[]{i - 1, i + 1, i, i};
        int[] ys = new int[]{j, j, j - 1, j + 1};
        for (int k = 0; k < 4; k++) {
            int x = xs[k], y = ys[k];
            if (valid(m, n, x, y) && helper[x][y] == 0) {
                boolean res = backtrack(board, m, n, x, y, word, idx + 1);
                if (res) {
                    helper[i][j] = 0;
                    return true;
                }
            }
        }
        helper[i][j] = 0;
        return false;
    }

    private boolean valid(int m, int n, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}
