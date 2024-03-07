package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/out-of-boundary-paths/?show=1">No576 出界的路径数</a>
 **/
public class No576_FindPaths {

    int[][][] memo;
    int mod = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        memo = new int[51][51][51];
        for (int[][] rows : memo) {
            for (int[] row : rows) {
                Arrays.fill(row, -1);
            }
        }
        int res = 0;
        for (int i = 0; i < maxMove; i++) {
            res = (res + dp(m, n, i + 1, startRow, startColumn) % mod) % mod;

        }
        return res;
    }

    public int dp(int m, int n, int maxMove, int startRow, int startColumn) {
        if (startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n) {
            // 坐标越界，如果此时刚好没有步数了则结果加1，否则不需要加
            return maxMove == 0 ? 1 : 0;
        }
        if (maxMove == 0) {
            return 0;
        }
        if (memo[startRow][startColumn][maxMove] != -1) {
            return memo[startRow][startColumn][maxMove];
        }

        int moveLeft = dp(m, n, maxMove - 1, startRow, startColumn - 1);
        int res = moveLeft % mod;
        int moveRight = dp(m, n, maxMove - 1, startRow, startColumn + 1);
        res = (res + moveRight % mod) % mod;
        int moveUp = dp(m, n, maxMove - 1, startRow - 1, startColumn);
        res = (res + moveUp % mod) % mod;
        int moveDown = dp(m, n, maxMove - 1, startRow + 1, startColumn);
        res = (res + moveDown % mod) % mod;
        memo[startRow][startColumn][maxMove] = res;
        return res;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {2, 2, 2, 0, 0, 6},
                {1, 3, 3, 0, 1, 12},
                {8, 50, 23, 5, 26, 914783380},
                {36, 5, 50, 15, 3, 390153306},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int m, int n, int maxMove, int startRow, int startCol, int expected) {
        int res = findPaths(m, n, maxMove, startRow, startCol);
        Assert.assertEquals(res, expected);
    }

}
