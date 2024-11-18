package Lc;

import org.testng.Assert;
import org.testng.annotations.Test;

public class No44IsMatch {

    int[][] helper;

    public boolean isMatch(String s, String p) {
        helper = new int[s.length() + 1][p.length() + 1];
        return dp(s, 0, p, 0);
    }

    public boolean dp(String s, int i, String p, int j) {
        if (i == s.length() && j == p.length()) {
            return true;
        }
        if (i < s.length() && j >= p.length()) {
            // p用完了，返回false
            return false;
        }
        if (helper[i][j] != 0) {
            return helper[i][j] == 1;
        }
        if (i == s.length()) {
            // s用完了，p剩下的只能都是*，否则就是不匹配
            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*') {
                    helper[i][j] = 2;
                    return false;
                }
            }
            helper[i][j] = 1;
            return true;
        }
        boolean res = false;
        if (p.charAt(j) == '?') {
            res = dp(s, i + 1, p, j + 1);
        } else if (p.charAt(j) == '*') {
            res = dp(s, i + 1, p, j) || dp(s, i + 1, p, j + 1) || dp(s, i, p, j + 1);
        } else if (p.charAt(j) == s.charAt(i)) {
            res = dp(s, i + 1, p, j + 1);
        } else {
            helper[i][j] = 2;
            return false;
        }
        helper[i][j] = res ? 1 : 2;
        return res;
    }

    @Test(description = "")
    public void test() throws Exception {
        Assert.assertTrue(isMatch("abcabczzzde", "*abc???de*"));
        Assert.assertTrue(isMatch("", "***"));
        Assert.assertTrue(isMatch("adceb", "*a*b"));
        Assert.assertFalse(isMatch("aa", "a"));
        Assert.assertFalse(isMatch("aa", "?b"));
        Assert.assertTrue(isMatch("aa", "?a"));
        Assert.assertTrue(isMatch("aa", "*"));
        Assert.assertFalse(isMatch("aa", "*c"));

    }
}
