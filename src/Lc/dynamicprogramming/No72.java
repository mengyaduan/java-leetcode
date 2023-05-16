package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/edit-distance/">编辑距离</a>
 **/
public class No72 {

    int[][] memo;

    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(word1, 0, word2, 0);
    }

    public int dp(String word1, int i, String word2, int j) {
        String w1 = word1.substring(i);
        String w2 = word2.substring(j);
        if (w1.length() == 0 || w2.length() == 0) {
            // 任意一个为空时，结果都是另一个非空的长度
            return w1.length() + w2.length();
        }
        if (w1.length() == 1 || w2.length() == 1) {
            // 任意一个为1时，结果取决于长的是否包含短的：包含时，返回长字符串长度-1，否则为长字符串长度
            String longOne = w1.length() == 1 ? w2 : w1;
            String shortOne = w1.length() == 1 ? w1 : w2;
            if (longOne.contains(shortOne)) {
                return longOne.length() - 1;
            } else {
                return longOne.length();
            }
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int minRes = Integer.MAX_VALUE;

        // 首位替换，i，j一起前进
        int removeFirst = dp(word1, i + 1, word2, j + 1);
        int replaceFirst = removeFirst + 1;
        int first = w1.charAt(0) == w2.charAt(0) ? removeFirst : replaceFirst;
        minRes = Math.min(minRes, first);
        // 首位删除，i前进，j不动
        int delFirst = dp(word1, i + 1, word2, j) + 1;
        minRes = Math.min(minRes, delFirst);
        // 前置添加，i不动，j前进
        int insFirst = dp(word1, i, word2, j + 1) + 1;
        minRes = Math.min(minRes, insFirst);
        memo[i][j] = minRes;
        return memo[i][j];
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {"horse", "ros", 3},
                {"intention", "execution", 5},
                {"a", "bc", 2},
                {"a", "ba", 1},
                {"abef", "c", 4},
                {"acef", "c", 3},
                {"ab", "cd", 2},
                {"ab", "ca", 2},
                {"", "", 0},
                {"a", "", 1},
                {"", "b", 1},
                {"sea", "eat", 2},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, String t, int expected) {
        int res = minDistance(s, t);
        Assert.assertEquals(res, expected);
    }


    @Test(description = "")
    public void testdlkasfj() throws Exception {
        String x = "";
        String m = x.substring(0);
        System.out.println(m.length());

    }
}
