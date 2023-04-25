package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/maximal-square/?show=1/">No221 最大正方形</a>
 **/
public class No221 {


    public int maximalSquare(char[][] matrix) {
        int result = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 || j == n - 1) {
                    memo[i][j] = matrix[i][j] - '0';
                } else if (matrix[i][j] == '0') {
                    memo[i][j] = 0;
                } else {
                    memo[i][j] = Math.min(Math.min(memo[i + 1][j], memo[i][j + 1]), memo[i + 1][j + 1]) + 1;
                }
                if (memo[i][j] > result) {
                    result = memo[i][j];
                }
            }
        }
        return result * result;
    }


    int[][] memo;

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}, 4},
                {new char[][]{{'0', '1'}, {'1', '0'}}, 1},
                {new char[][]{{'0'}}, 0},
                {new char[][]{{'1'}}, 1},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(char[][] matrix, int expected) {
        int res = maximalSquare(matrix);
        Assert.assertEquals(res, expected);
    }
}
