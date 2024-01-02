package Lc.KrahetsInterview.DoublePointers;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/is-subsequence/description/">判断子序列</a>
 **/
public class No392 {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                {"", "ahbgdc", true},
                {"ba", "", false},
                {"abc", "ahbgdc", true},
                {"axc", "ahbgdc", false},
                {"ac", "ahbgdc", true},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, String t, boolean expected) {
        boolean res = isSubsequence(s, t);
        Assert.assertEquals(res, expected);

    }

}

