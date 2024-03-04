package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/minimum-falling-path-sum/">下降路径最小和</a>
 **/
public class No931_MinFallingPathSum {

    int[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] lineUp = matrix[0].clone();
        for (int i = 1; i < m; i++) {
            int[] line = new int[n];
            for (int j = 0; j < n; j++) {
                int upLeft = j > 0 ? lineUp[j - 1] : Integer.MAX_VALUE;
                int upRight = j + 1 < n ? lineUp[j + 1] : Integer.MAX_VALUE;
                int upMid = lineUp[j];
                line[j] = matrix[i][j] + Math.min(upLeft, Math.min(upRight, upMid));
            }
            lineUp = line.clone();
        }
        int res = Arrays.stream(lineUp).min().getAsInt();
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
