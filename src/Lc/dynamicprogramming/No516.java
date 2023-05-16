package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/longest-palindromic-subsequence/">最长回文子串</a>
 **/
public class No516 {
    int[][] memo;

    public int longestPalindromeSubseq(String s) {
        memo = new int[s.length()][s.length()];
        for (int[] row : memo) {
            Arrays.fill(row, 0);
        }
        return dp(0, s.length() - 1, s);
    }

    public int dp(int i, int j, String s) {
        if (i == j) {
            return 1;
        }
        if (i > j) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int res = 0;
        if (s.charAt(i) == s.charAt(j)) {
            res = dp(i + 1, j - 1, s) + 2;
        } else {
            res = Math.max(dp(i + 1, j, s), dp(i, j - 1, s));
        }
        memo[i][j] = res;
        return res;

    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {"bbbab", 4},
                {"cbbd", 2},
                {"a", 1},
                {"ab", 1},
                {"aa", 2},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, int expected) {
        int res = longestPalindromeSubseq(s);
        Assert.assertEquals(res, expected);
    }

}
