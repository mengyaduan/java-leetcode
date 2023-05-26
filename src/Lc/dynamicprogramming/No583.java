package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/delete-operation-for-two-strings/">两个字符串的删除操作</a>
 **/
public class No583 {

    int[][] memo;

    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(word1, 0, word2, 0);
    }

    public int dp(String s, int i, String t, int j) {
        if (i == s.length() || j == t.length()) {
            // 如果任意一个为空，则需要把另外的全删掉
            return i == s.length() ? t.length() - j : s.length() - i;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (i == s.length() - 1 || j == t.length() - 1) {
            String sNew = s.substring(i);
            String tNew = t.substring(j);
            // 如果任意一个长度为1，例如s，则判断t是否包含s，如果包含，删除t.len-1，否则把s，t全删了，即t.len+1
            if (sNew.length() == 1) {
                return tNew.length() + (tNew.contains(sNew) ? -1 : 1);
            } else {
                return sNew.length() + (sNew.contains(tNew) ? -1 : 1);
            }
        }

        if (s.charAt(i) == t.charAt(j)) {
            memo[i][j] = dp(s, i + 1, t, j + 1);
        } else {
            int a = dp(s, i + 1, t, j + 1) + 2;
            int b = dp(s, i, t, j + 1) + 1;
            int c = dp(s, i + 1, t, j) + 1;
            memo[i][j] = a < b ? a : b;
            memo[i][j] = memo[i][j] < c ? memo[i][j] : c;
        }
        return memo[i][j];
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {"sea", "eat", 2},
                {"leetcode", "etco", 4},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, String t, int expected) {
        int res = minDistance(s, t);
        Assert.assertEquals(res, expected);
    }

}
