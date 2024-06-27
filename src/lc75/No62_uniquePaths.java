package lc75;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/unique-paths/description/?envType=study-plan-v2&envId=leetcode-75">不同路径</a>
 */
public class No62_uniquePaths {

    int[][] memo;

    public int uniquePaths(int m, int n) {
        memo = new int[m + 1][n + 1];
        return dp(m, n);
    }

    public int dp(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        if (m == 2 || n == 2) {
            return m == 2 ? n : m;
        }
        if (memo[m][n] != 0) {
            return memo[m][n];
        }
        memo[m][n] = dp(m - 1, n) + dp(m, n - 1);
        return memo[m][n];
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(uniquePaths(3, 7));

    }
}
