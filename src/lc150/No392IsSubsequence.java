package lc150;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No392IsSubsequence {

    int[][] memo;

    public boolean isSubsequence(String s, String t) {
        memo = new int[s.length()][t.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        if (s.length() > t.length()) {
            return false;
        }
        return dp(s, 0, t, 0);
    }

    public boolean dp(String s, int i, String t, int j) {
        if (i >= s.length()) {
            return true;
        }
        if (j >= t.length()) {
            return false;
        }
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }
        boolean x = false;
        if (s.charAt(i) == t.charAt(j)) {
            x = dp(s, i + 1, t, j + 1);
        }
        memo[i][j] = (x || dp(s, i, t, j + 1)) ? 1 : 0;
        return memo[i][j] == 1;
    }

}
