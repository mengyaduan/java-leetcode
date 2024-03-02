package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/minimum-path-sum/description/">最小路径和</a>
 **/
public class No64 {

    /**
     * 思路：
     * dp[i][j] = Min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
     **/


    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    memo[i][j] = grid[0][0];
                } else if (i == 0) {
                    memo[i][j] = memo[0][j - 1] + grid[0][j];
                } else if (j == 0) {
                    memo[i][j] = memo[i - 1][0] + grid[i][0];
                } else {
                    memo[i][j] = Math.min(memo[i - 1][j], memo[i][j - 1]) + grid[i][j];
                }
            }
        }
        return memo[m - 1][n - 1];
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}, 7},
                {new int[][]{{1, 2, 3}, {4, 5, 6}}, 12},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[][] grid, int expected) {
        int res = minPathSum(grid);
        Assert.assertEquals(res, expected);
    }

}
