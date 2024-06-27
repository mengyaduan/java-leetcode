package lc75;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/longest-common-subsequence/description/?envType=study-plan-v2&envId=leetcode-75">最长公共子串</a>
 */
public class No1143_longestCommonSubsequence {

    int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(text1, 0, text2, 0);
    }

    public int dp(String s1, int i, String s2, int j) {
        if (i >= s1.length() || j >= s2.length()) {
            // 走到头了
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res;
        if (s1.charAt(i) == s2.charAt(j)) {
            // 如果相同，可以走，或者不走
            int a = dp(s1, i + 1, s2, j);
            int b = dp(s1, i, s2, j + 1);
            int c = dp(s1, i + 1, s2, j + 1) + 1;
            res = Math.max(a, Math.max(b, c));
        } else {
            int a = dp(s1, i + 1, s2, j);
            int b = dp(s1, i, s2, j + 1);
            res = Math.max(a, b);
        }
        memo[i][j] = res;
        return res;
    }


    @Test(description = "")
    public void test() throws Exception {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence("abc", "def"));
    }
}
