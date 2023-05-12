package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/decode-ways/?show=1">字母解码</a>
 **/
public class No91Complicate {

    int[] memo;

    HashMap<String, String> alphabet = new HashMap<>();

    public int numDecodings(String s) {
        int asciiA = 65;
        for (int i = 1; i <= 26; i++) {
            alphabet.put(String.valueOf(i), String.valueOf((char) asciiA));
            asciiA++;
        }
        memo = new int[s.length() + 10];
        Arrays.fill(memo, -1);


        return dp(0, s);
    }

    int dp(int index, String s) {
        if (index > s.length()) {
            return 0;
        }
        if (s.length() - index == 1) {
            return alphabet.containsKey(s.substring(index)) ? 1 : 0;
        }
        if (s.length() == index) {
            return 1;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        int x = 0;
        int y = 0;
        if (index + 1 <= s.length()) {
            String singleS = s.substring(index, index + 1);
            if (alphabet.containsKey(singleS) && !s.substring(index + 1).startsWith("0")) {
                x = dp(index + 1, s);
            }
        }
        if (index + 2 <= s.length()) {
            String doubleS = s.substring(index, index + 2);
            if (alphabet.containsKey(doubleS) && !s.substring(index + 2).startsWith("0")) {
                y = dp(index + 2, s);
            }
        }
        memo[index + 1] = x;
        memo[index + 2] = y;
        memo[index] = x + y;
        return memo[index];
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {"1", 1},
                {"0", 0},
                {"06", 0},
                {"26", 2},
                {"226", 3},
                {"1201234", 3},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(String n, int expected) {
        int res = numDecodings(n);
        Assert.assertEquals(res, expected);
    }

    @Test(description = "")
    public void testldkajfl() throws Exception {
        String x = "01234";
        System.out.println(x.substring(5));
    }

}
