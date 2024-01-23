package Lc.KrahetsInterview.DynamicProgram;

/**
 * @see <a href="https://leetcode.com/problems/minimum-path-sum/description/">最小路径和</a>
 **/
public class No64 {


    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        memo[0][0] = grid[0][0];

        // 初始化边界
        for (int i = 1; i < m; i++) {
            memo[i][0] = grid[i][0] + memo[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            memo[0][i] = grid[0][i] + memo[0][i - 1];
        }

        // 计算每个格子的值
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                memo[i][j] = Math.min(memo[i - 1][j], memo[i][j - 1]) + grid[i][j];
            }
        }

        return memo[m - 1][n - 1];
    }


}

