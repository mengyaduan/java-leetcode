package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/longest-common-subsequence/">最长公共序列</a>
 **/
public class No1143 {

    int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(text1, 0, text2, 0);
    }

    public int dp(String s, int i, String t, int j) {
        if (i == s.length() || j == t.length()) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        String sNew = s.substring(i);
        String tNew = t.substring(j);
        if (i == s.length() - 1) {
            return tNew.contains(sNew) ? 1 : 0;
        }
        if (j == t.length() - 1) {
            return sNew.contains(tNew) ? 1 : 0;
        }
        if (s.charAt(i) == t.charAt(j)) {
            memo[i][j] = 1 + dp(s, i + 1, t, j + 1);
        } else {
            int a = dp(s, i + 1, t, j + 1);
            int b = dp(s, i, t, j + 1);
            int c = dp(s, i + 1, t, j);
            memo[i][j] = a > b ? a : b;
            memo[i][j] = memo[i][j] > c ? memo[i][j] : c;
        }
        return memo[i][j];
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {"abcde", "ace", 3},
                {"abc", "abc", 3},
                {"abc", "zxy", 0},
                {"bsbininm", "jmjkbkjkv", 1},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, String t, int expected) {
        int res = longestCommonSubsequence(s, t);
        Assert.assertEquals(res, expected);
    }

}
