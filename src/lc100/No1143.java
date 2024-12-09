package lc100;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class No1143 {

    int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(text1.toCharArray(), 0, text2.toCharArray(), 0);
    }

    private int dp(char[] c1, int i, char[] c2, int j) {
        if (i >= c1.length || j >= c2.length) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = dp(c1, i + 1, c2, j);
        res = Math.max(res, dp(c1, i, c2, j + 1));
        if (c1[i] == c2[j]) {
            res = Math.max(dp(c1, i + 1, c2, j + 1) + 1, res);
        }
        memo[i][j] = res;
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(longestCommonSubsequence("abc", "abc"), 3);
        Assert.assertEquals(longestCommonSubsequence("ace", "abcde"), 3);
        Assert.assertEquals(longestCommonSubsequence("ace", "dfm"), 0);

    }


}
