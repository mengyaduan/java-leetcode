package lc100;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class No72 {


    int[][] memo;

    public int minDistance(String word1, String word2) {
        memo = new int[word1.length() + 1][word2.length() + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        return dp(w1, 0, w2, 0);
    }

    private int dp(char[] w1, int i, char[] w2, int j) {
        if (j >= w2.length) {
            return w1.length - i;
        }
        if (i >= w1.length) {
            return w2.length - j;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = 0;
        // 如果字符一致，直接前进
        if (w1[i] == w2[j]) {
            res += dp(w1, i + 1, w2, j + 1);
        } else {
            // 增加一个、替换、删除
            int a = dp(w1, i, w2, j + 1) + 1;
            int b = dp(w1, i + 1, w2, j + 1) + 1;
            int c = dp(w1, i + 1, w2, j) + 1;
            res += Math.min(a, Math.min(b, c));
        }
        memo[i][j] = res;
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertEquals(minDistance("horse", "ros"), 3);
        Assert.assertEquals(minDistance("intention", "execution"), 5);

    }
}
