package Lc119;

public class LCR096 {

    public boolean isInterleave(String s1, String s2, String s3) {
        char[] sc1 = s1.toCharArray();
        char[] sc2 = s2.toCharArray();
        char[] sc3 = s3.toCharArray();
        if (sc3.length != sc1.length + sc2.length) {
            return false;
        }
        int[][][] memo = new int[sc1.length + 1][sc2.length + 1][sc3.length + 1];
        return dp(sc1, 0, sc2, 0, sc3, 0, memo);
    }

    private boolean dp(char[] sc1, int i, char[] sc2, int j, char[] sc3, int k, int[][][] memo) {
        if (i == sc1.length && j == sc2.length && k == sc3.length) {
            return true;
        }
        if (memo[i][j][k] != 0) {
            return memo[i][j][k] == 1;
        }
        boolean res = false;
        if (i == sc1.length) {
            if (sc2[j] == sc3[k]) {
                res = dp(sc1, i, sc2, j + 1, sc3, k + 1, memo);
            }
        } else if (j == sc2.length) {
            if (sc1[i] == sc3[k]) {
                res = dp(sc1, i + 1, sc2, j, sc3, k + 1, memo);
            }
        } else if (sc1[i] == sc3[k] && sc2[j] != sc3[k]) {
            res = dp(sc1, i + 1, sc2, j, sc3, k + 1, memo);
        } else if (sc1[i] != sc3[k] && sc2[j] == sc3[k]) {
            res = dp(sc1, i, sc2, j + 1, sc3, k + 1, memo);
        } else if (sc1[i] == sc3[k] && sc2[j] == sc3[k]) {
            res = dp(sc1, i + 1, sc2, j, sc3, k + 1, memo) || dp(sc1, i, sc2, j + 1, sc3, k + 1, memo);
        }
        memo[i][j][k] = res ? 1 : 2;
        return res;
    }

}
