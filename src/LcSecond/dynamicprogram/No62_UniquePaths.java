package LcSecond.dynamicprogram;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/unique-paths/description/">二维表格上的所有路径总数</a>
 */
public class No62_UniquePaths {

    int[][] memo;

    public int uniquePaths(int m, int n) {
        memo = new int[m + 1][n + 1];
        for (int[] item : memo) {
            Arrays.fill(item, -1);
        }
        return dp(m, n);
    }

    public int dp(int x, int y) {
        if (x == 1 || y == 1) {
            return 1;
        }
        if (x == 2 || y == 2) {
            return x == 2 ? y : x;
        }
        if (memo[x][y] != -1) {
            return memo[x][y];
        }
        int res = dp(x - 1, y) + dp(x, y - 1);
        memo[x][y] = res;
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(1, 2));

    }
}
