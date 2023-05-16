package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/unique-paths/?show=1">No62 不同路径</a>
 **/
public class No62 {
    /**
     * 思路：
     * m，n任意为2时，结果都是另一个值，所以直接动态规划到任意维度为2，即可
     **/

    int[][] memo;

    public int uniquePaths(int m, int n) {
        memo = new int[m + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(m, n);
    }

    public int dp(int m, int n) {
        if (m == 2 || n == 2) {
            return m == 2 ? n : m;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        int down = dp(m - 1, n);
        int right = dp(m, n - 1);
        memo[m - 1][n] = down;
        memo[m][n - 1] = right;
        memo[m][n] = down + right;
        return down + right;


    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {3, 7, 28},
                {2, 3, 3},
                {3, 3, 6},
                {4, 4, 20},
                {1, 10, 1},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int m, int n, int expected) {
        int res = uniquePaths(m, n);
        Assert.assertEquals(res, expected);
    }

}
