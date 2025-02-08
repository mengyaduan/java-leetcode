package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/longest-common-subsequence/">最长公共序列</a>
 **/
public class No1143LCS {


    public int longestCommonSubsequence(String text1, String text2) {
        int[][] table = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }
        return table[text1.length()][text2.length()];
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {"abcde", "ace", 3},
                {"ace", "abcde", 3},
                {"abc", "abc", 3},
                {"abc", "zxy", 0},
                {"bsbininm", "jmjkbkjkv", 1},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, String t, int expected) {
        int res = longestCommonSubsequence(s, t);
        Assert.assertEquals(res, expected);
    }

}
