package Lc119;

import com.sun.org.apache.xerces.internal.impl.XMLEntityManager;

public class LCR098 {

    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m + 1][n + 1];
        return dp(m, n, memo);
    }

    private int dp(int m, int n, int[][] memo) {
        if (m == 1 || n == 1) {
            return 1;
        }
        if (m == 2 || n == 2) {
            return m == 2 ? n : m;
        }
        if (memo[m][n] != 0) {
            return memo[m][n];
        }
        int res = dp(m - 1, n, memo) + dp(m, n - 1, memo);
        memo[m][n] = res;
        return res;
    }
}
