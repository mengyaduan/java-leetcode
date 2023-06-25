package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/regular-expression-matching/">正则表达式</a>
 **/
public class No10 {


    int[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new int[s.length()][p.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        if (p.equals(".*")) {
            return true;
        }

        return dp(s, 0, p, 0);
    }

    public boolean dp(String s, int i, String p, int j) {
        if (i < s.length() && j < p.length()) {
            System.out.println(String.format("当前计算的是（%s, %s）", s.substring(i), p.substring(j)));
        }
        if (i == s.length()) {
            if (j == p.length()) {
                return true;
            }
            int k = p.length() - 1;
            while (k >= j) {
                if (p.charAt(k) == '*') {
                    k -= 2;
                } else {
                    break;
                }
            }
            if (k >= j) {
                return false;
            } else {
                return true;
            }
        }
        if (j >= p.length()) {
            return false;
        }
        if (memo[i][j] != -1) {
            return memo[i][j] == 1 ? true : false;
        }
        // 情况1：当前位置匹配，且下一位是*，则s可以选择前进or停止，p可以选择前进or停止
        // 情况2：当前位置匹配，且下一位不是*，则s和p只能选择前进
        // 情况3：当前位置不匹配，且下一位是*，则s停止，p可以选择前进到*之后
        // 情况4：当前位置不匹配，且下一位不是*，则一定匹配不上，直接置为false

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                // 处理1
                boolean pStay = dp(s, i + 1, p, j);
                boolean pMove = dp(s, i + 1, p, j + 2);
                boolean sStay = dp(s, i, p, j + 2);
                memo[i][j] = (pStay || pMove || sStay) ? 1 : 0;
            } else {
                // 处理2
                boolean pMove = dp(s, i + 1, p, j + 1);
                memo[i][j] = pMove ? 1 : 0;
            }
        } else {
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                // 处理3
                boolean pMove = dp(s, i, p, j + 2);
                memo[i][j] = pMove ? 1 : 0;
            } else {
                // 处理4
                memo[i][j] = 0;
            }
        }
        return memo[i][j] == 1 ? true : false;
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {"aa", "a", false},
                {"aa", "a*", true},
                {"ab", ".*", true},
                {"aab", "a*", false},
                {"aab", "a*.", true},
                {"abc", "a*.", false},
                {"aab", "ab.", false},
                {"aab", "a.b", true},
                {"a", "a*", true},
                {"aab", "c*a*b*", true},
                {"aab", "c*", false},
                {"aaa", "ab*a*c*a", true},
                {"a", "ab*", true},
                {"ab", ".*c", false},
                {"a", ".*..a*", false},

        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, String p, boolean expected) {
        boolean res = isMatch(s, p);
        Assert.assertEquals(res, expected);
    }

}
