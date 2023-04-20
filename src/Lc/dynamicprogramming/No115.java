package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/distinct-subsequences/?show=1">No115 不同的子序列</a>
 **/
public class No115 {

    int[][] memo;

    public int numDistinct(String s, String t) {

        memo = new int[s.length() + 1][t.length() + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(s, 0, t, 0);
    }

    public int dp(String s, int i, String t, int j) {
        if (j >= t.length()) {
            return 1;
        }
        if (i >= s.length() || s.length() - i < t.length() - j) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = 0;
        if (s.charAt(i) == t.charAt(j)) {
            res = dp(s, i + 1, t, j + 1) + dp(s, i + 1, t, j);
        } else {
            res = dp(s, i + 1, t, j);
        }
        memo[i][j] = res;
        return res;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {"rabbbit", "rabbit", 3},
                {"babgbag", "bag", 5},
                {"a", "a", 1},
                {"adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc", "bcddceeeebecbc", 700531452}
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, String t, int expected) {
        int res = numDistinct(s, t);
        Assert.assertEquals(res, expected);
    }
}
