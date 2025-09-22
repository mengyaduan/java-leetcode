package LC100Again;


import org.testng.annotations.Test;

import java.util.Arrays;

public class Lc095 {

    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int[][] memo = new int[w1.length][w2.length];
        for (int[] rows : memo) {
            Arrays.fill(rows, -1);
        }
        return dp(w1, 0, w2, 0, memo);
    }

    private int dp(char[] w1, int i, char[] w2, int j, int[][] memo) {
        if (i >= w1.length || j >= w2.length) {
            // w1用完了，则需要补充w2，w2用完了则需要删除w1
            return i >= w1.length ? (w2.length - j) : (w1.length - i);
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = Integer.MAX_VALUE;
        // 增加一个字符，w2前进
        res = Math.min(res, dp(w1, i, w2, j + 1, memo) + 1);
        // 修改一个字符，共同前进
        res = Math.min(res, dp(w1, i + 1, w2, j + 1, memo) + 1);
        // 删除一个字符，w1前进
        res = Math.min(res, dp(w1, i + 1, w2, j, memo) + 1);
        if (w1[i] == w2[j]) {
            // 如果一样，共同前进
            res = Math.min(res, dp(w1, i + 1, w2, j + 1, memo));
        }
        memo[i][j] = res;
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(minDistance("park", "spake"));

    }

}
