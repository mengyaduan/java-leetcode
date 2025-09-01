package LC100Again;


public class Lc060 {

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        int[][] memo = new int[m][n];
        char[] w = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean res = dfs(board, i, j, w, 0, memo);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean dfs(char[][] board, int i, int j, char[] wc, int idx, int[][] memo) {
        if (idx == wc.length) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            // 越界，此路不通
            return false;
        }
        if (wc[idx] != board[i][j] || memo[i][j] == 1) {
            // 不相等，或者已经用过了，此路不通
            return false;
        }
        // 相等，且没用过，此时标记为使用过
        memo[i][j] = 1;
        // 向上下左右dfs
        if (dfs(board, i - 1, j, wc, idx + 1, memo)) return true;
        if (dfs(board, i + 1, j, wc, idx + 1, memo)) return true;
        if (dfs(board, i, j - 1, wc, idx + 1, memo)) return true;
        if (dfs(board, i, j + 1, wc, idx + 1, memo)) return true;
        memo[i][j] = 0;
        return false;
    }

}
