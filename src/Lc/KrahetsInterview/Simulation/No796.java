package Lc.KrahetsInterview.Simulation;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/rotate-string/description/">旋转字符串</a>
 **/
public class No796 {

    public boolean rotateStringAnswer(String s, String goal) {
        return s.length() == goal.length() && (goal + goal).contains(s);
    }

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String s2 = s + s.substring(0, s.length() - 1);
        int i = 0;
        while (i < s2.length()) {
            int m = i;
            int n = 0;
            while (m < s2.length() && n < goal.length() && s2.charAt(m) == goal.charAt(n)) {
                m++;
                n++;
            }
            if (n == goal.length()) {
                return true;
            } else {
                i++;
            }
        }
        return false;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                //
                {"abcde", "cdeab", true},
                {"abcde", "abced", false},
                {"vcuszhlbtpmksjleuchmjffufrwpiddgyynfujnqblngzoogzg", "fufrwpiddgyynfujnqblngzoogzgvcuszhlbtpmksjleuchmjf", true},
                {"abcde", "abcdg", false},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String s, String goal, boolean expected) {
        boolean res = rotateString(s, goal);
        Assert.assertEquals(res, expected);

    }

}

