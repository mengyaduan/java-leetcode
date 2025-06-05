package Lc119;

public class LCR095 {


    public int longestCommonSubsequence(String text1, String text2) {
        char[] sc1 = text1.toCharArray();
        char[] sc2 = text2.toCharArray();
        int[][] memo = new int[sc1.length][sc2.length];
        return dp(sc1, 0, sc2, 0, memo);
    }

    private int dp(char[] sc1, int i, char[] sc2, int j, int[][] memo) {
        if (i >= sc1.length || j >= sc2.length) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int result = Integer.MIN_VALUE;
        if (sc1[i] == sc2[j]) {
            result = Math.max(result, 1 + dp(sc1, i + 1, sc2, j + 1, memo));
        }
        result = Math.max(result, dp(sc1, i, sc2, j + 1, memo));
        result = Math.max(result, dp(sc1, i + 1, sc2, j, memo));
        memo[i][j] = result;
        return result;
    }

}
