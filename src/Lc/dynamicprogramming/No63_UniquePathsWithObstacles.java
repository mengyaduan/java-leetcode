package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/unique-paths-ii/?show=1">No63 不同路径ii</a>
 **/
public class No63_UniquePathsWithObstacles {

    /**
     * 思路：
     * 如果已经到最下面一行或者最右面一列，那么是否能够到达终点，取决于j到n-1是否有阻碍
     **/

    int[][] memo;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        memo = new int[m][n];
        for (int[] i : memo) {
            Arrays.fill(i, -1);
        }
        return dp(0, 0, obstacleGrid);
    }

    public int dp(int i, int j, int[][] obstacleGrid) {
        if (i >= obstacleGrid.length || j >= obstacleGrid[0].length || obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
            return 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int right = dp(i, j + 1, obstacleGrid);
        int down = dp(i + 1, j, obstacleGrid);
        memo[i][j] = right + down;
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
