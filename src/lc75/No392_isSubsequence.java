package lc75;

import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/is-subsequence/description/?envType=study-plan-v2&envId=leetcode-75">判断子序列</a>
 */
public class No392_isSubsequence {

    int[][] memo;

    public boolean isSubsequence(String s, String t) {
        memo = new int[s.length()][t.length()];
        return dp(s, 0, t, 0);
    }

    public boolean dp(String s, int i, String t, int j) {
        if (i == s.length()) {
            return true;
        }
        if (j == t.length()) {
            return false;
        }
        if (memo[i][j] != 0) {
            return memo[i][j] == 1;
        }

        boolean res = false;
        if (s.charAt(i) == t.charAt(j)) {
            res = dp(s, i + 1, t, j + 1) || dp(s, i, t, j + 1);
        } else {
            res = dp(s, i, t, j + 1);
        }
        memo[i][j] = res ? 1 : 2;
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));

    }
}
