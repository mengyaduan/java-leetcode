package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/unique-paths-ii/?show=1">No63 不同路径ii</a>
 **/
public class No63 {

    /**
     * 思路：
     * 如果已经到最下面一行或者最右面一列，那么是否能够到达终点，取决于j到n-1是否有阻碍
     **/

    int[][] memo;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        memo = new int[m + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(0, 0, m, n, obstacleGrid);
    }

    public int dp(int i, int j, int m, int n, int[][] obstacleGrid) {
        if (obstacleGrid[i][j] == 1) {
            return 0;
        }
        // 如果已经到最下面一行了，那么是否能够到达终点，取决于j到n-1是否有阻碍
        if (i == m - 1) {
            boolean canPass = true;
            for (int k = j; k < n; k++) {
                if (obstacleGrid[i][k] == 1) {
                    canPass = false;
                    break;
                }
            }
            return canPass ? 1 : 0;
        }
        // 如果已经到最右面一列了，那么是否能够到达终点，取决于i到m-1是否有阻碍
        if (j == n - 1) {
            boolean canPass = true;
            for (int k = i; k < m; k++) {
                if (obstacleGrid[k][j] == 1) {
                    canPass = false;
                    break;
                }
            }
            return canPass ? 1 : 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int down = dp(i + 1, j, m, n, obstacleGrid);
        int right = dp(i, j + 1, m, n, obstacleGrid);
        memo[i + 1][j] = down;
        memo[i][j + 1] = right;
        memo[i][j] = down + right;
        return down + right;


    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}, 2},
                {new int[][]{{0, 1, 0}, {0, 1, 0}}, 0},
                {new int[][]{{0, 1}, {0, 0}}, 1},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[][] grid, int expected) {
        int res = uniquePathsWithObstacles(grid);
        Assert.assertEquals(res, expected);
    }

}
