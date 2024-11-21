package lc100;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class No62 {


    int[][] memo;

    public int uniquePaths(int m, int n) {
        memo = new int[m + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(0, 0, m, n);
    }

    public int dp(int i, int j, int m, int n) {
        if (i == m - 1 || j == n - 1) {
            // 抵达边界
            return 1;
        }
        if (i == m - 2 || j == n - 2) {
            // 抵达倒数第二行/列
            return i == m - 2 ? n - j : m - i;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = dp(i + 1, j, m, n) + dp(i, j + 1, m, n);
        memo[i][j] = res;
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(uniquePaths(3, 7), 28);
        Assert.assertEquals(uniquePaths(3, 2), 3);
        Assert.assertEquals(uniquePaths(3, 3), 6);

    }
}
