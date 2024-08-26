package lc150;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/minimum-path-sum/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No60MinPathSum {
    int[][] helper;

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        helper = new int[m][n];
        // init row0 col0
        helper[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            helper[0][i] = grid[0][i] + helper[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            helper[i][0] = helper[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                helper[i][j] = Math.min(helper[i - 1][j], helper[i][j - 1]) + grid[i][j];
            }
        }
        return helper[m - 1][n - 1];
    }

    @Test(description = "")
    public void test() throws Exception {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
        };
        System.out.println(minPathSum(grid));

    }
}
