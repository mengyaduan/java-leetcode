package lc100;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No79 {


    int[][] used;


    /**
     * 不能使用memo[i][j][k]记录结果，因为即使相同的ijk，也会存在used情况不同的场景
     */
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        used = new int[m][n];
        boolean res = false;
        for (int i = 0; i < m && !res; i++) {
            for (int j = 0; j < n && !res; j++) {
                if (board[i][j] == w[0]) {
                    res = dfs(board, i, j, w, 0);
                }
            }
        }
        return res;
    }

    /**
     * 向 i,j的四面八法继续搜索
     */
    private boolean dfs(char[][] board, int i, int j, char[] w, int k) {
        if (k == w.length) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            // 越界直接返回
            return false;
        }

        if (used[i][j] == 1 || board[i][j] != w[k]) {
            // 走到已经使用过的，返回；当前和要的字符不一致
            return false;
        }

        used[i][j] = 1;
        boolean res = dfs(board, i - 1, j, w, k + 1) ||
                dfs(board, i + 1, j, w, k + 1) ||
                dfs(board, i, j - 1, w, k + 1) ||
                dfs(board, i, j + 1, w, k + 1);
        used[i][j] = 0;
        return res;
    }


    @Test(description = "")
    public void test1() throws Exception {

        char[][] grid = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        Assert.assertTrue(exist(grid, "ABCESEEEFS"));

    }

    @Test(description = "")
    public void test() throws Exception {
        char[][] grid = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        Assert.assertTrue(exist(grid, "ABCCED"));
        Assert.assertFalse(exist(grid, "SFX"));
        Assert.assertTrue(exist(grid, "EES"));
    }
}
