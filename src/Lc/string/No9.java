package Lc.string;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.cn/problems/palindrome-number/">No9 回文数</a>
 **/
public class No9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }

        }
        return true;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {121, true},
                {12121, true},
                {1221, true},
                {11, true},
                {1, true},
                {1231, false},
                {-121, false},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int nums, boolean expected) {
        boolean res = isPalindrome(nums);
        Assert.assertEquals(res, expected);
    }
}
