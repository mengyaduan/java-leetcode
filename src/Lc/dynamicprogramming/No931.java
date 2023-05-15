package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/minimum-falling-path-sum/">下降路径最小和</a>
 **/
public class No931 {

    int[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, 0);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == n - 1) {
                    memo[i][j] = matrix[i][j];
                } else {
                    int self = matrix[i][j];
                    if (j == 0) {
                        memo[i][j] = self + Math.min(memo[i + 1][j], memo[i + 1][j + 1]);
                    } else if (j == n - 1) {
                        memo[i][j] = self + Math.min(memo[i + 1][j - 1], memo[i + 1][j]);
                    } else {
                        memo[i][j] = Math.min(self + memo[i + 1][j - 1], self + memo[i + 1][j]);
                        memo[i][j] = Math.min(memo[i][j], self + memo[i + 1][j + 1]);
                    }
                }
            }
        }


        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (memo[0][i] < res) {
                res = memo[0][i];
            }
        }
        return res;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}, 13},
                {new int[][]{{-19, 57}, {-40, -5}}, -59},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[][] matrix, int expected) {
        int res = minFallingPathSum(matrix);
        Assert.assertEquals(res, expected);
    }
}
