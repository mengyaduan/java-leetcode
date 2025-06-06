package Lc119;

import org.testng.annotations.Test;

import java.util.Arrays;

public class LCR097 {


    public int numDistinct(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int[][] memo = new int[sc.length][tc.length];
        for (int[] rows : memo) {
            Arrays.fill(rows, -1);
        }
        return dp(sc, 0, tc, 0, memo);
    }

    private int dp(char[] sc, int i, char[] tc, int j, int[][] memo) {
        if (j >= tc.length) {
            return 1;
        }
        if (i >= sc.length) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = 0;
        if (sc[i] == tc[j]) {
            res = dp(sc, i + 1, tc, j + 1, memo);
        }
        res += dp(sc, i + 1, tc, j, memo);
        memo[i][j] = res;
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(numDistinct("aaba", "aa"));
        System.out.println(numDistinct("rabbbit", "rabbit"));

    }
}
