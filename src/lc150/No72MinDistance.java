package lc150;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/edit-distance/description/?envType=study-plan-v2&envId=top-interview-150"></a>
 */
public class No72MinDistance {
    int[][] memo;

    public int minDistance(String word1, String word2) {
        memo = new int[word1.length() + 1][word2.length() + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(word1.toCharArray(), 0, word2.toCharArray(), 0);
    }

    private int dp(char[] s1, int i, char[] s2, int j) {
        if (j >= s2.length) {
            // 需要把剩下的都删掉
            return s1.length - i;
        }
        if (i >= s1.length) {
            return s2.length - j;
        }
        if (memo[i][j] >= 0) {
            return memo[i][j];
        }

        int result = Integer.MAX_VALUE;
        // 插入
        result = Math.min(result, dp(s1, i, s2, j + 1) + 1);
        // 删除
        result = Math.min(result, dp(s1, i + 1, s2, j) + 1);
        // 更改（如果一致，可以不操作）
        int needOperation = s1[i] == s2[j] ? 0 : 1;
        result = Math.min(result, dp(s1, i + 1, s2, j + 1) + needOperation);
        memo[i][j] = result;
        return result;
    }

    @Test(description = "")
    public void test() throws Exception {
        System.out.println(minDistance("horse", "ros"));

    }


}
