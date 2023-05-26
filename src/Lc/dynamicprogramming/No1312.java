package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/">让字符串成为回文串的最少插入次数</a>
 **/
public class No1312 {

    int[][] memo;

    public int minInsertions(String s) {
        memo = new int[s.length()][s.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(s, 0, s.length() - 1);
    }

    public int dp(String s, int i, int j) {
        if (j <= i) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = dp(s, i + 1, j - 1);
        } else {
            int a = dp(s, i + 1, j) + 1;
            int b = dp(s, i, j - 1) + 1;
            memo[i][j] = a < b ? a : b;
        }
        return memo[i][j];
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {"a", 0},
                {"bb", 0},
                {"abcd", 3},
                {"zzazz", 0},
                {"mbadm", 2},
                {"leetcode", 5},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, int expected) {
        int res = minInsertions(s);
        Assert.assertEquals(res, expected);
    }

}
