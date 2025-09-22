package LC100Again;


import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;

public class Lc094 {

    public int longestCommonSubsequence(String text1, String text2) {
        int result = 0;
        int m = text1.length(), n = text2.length();
        int[][] memo = new int[m][n];
        for (int[] rows : memo) {
            Arrays.fill(rows, -1);
        }
        return dp(text1.toCharArray(), 0, text2.toCharArray(), 0, memo);
    }

    private int dp(char[] s, int i, char[] t, int j, int[][] memo) {
        if (i >= s.length || j >= t.length) {
            // 越界了，直接返回
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = Math.max(dp(s, i, t, j + 1, memo), dp(s, i + 1, t, j, memo));
        if (s[i] == t[j]) {
            res = Math.max(dp(s, i + 1, t, j + 1, memo) + 1, res);
        }
        memo[i][j] = res;
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(longestCommonSubsequence("abc", "edf"));
        System.out.println(longestCommonSubsequence("abc", "edc"));
        System.out.println(longestCommonSubsequence("ababc", "afbfdc"));

    }


}
