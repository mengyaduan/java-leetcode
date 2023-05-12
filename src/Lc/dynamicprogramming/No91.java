package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/decode-ways/?show=1">字母解码</a>
 **/
public class No91 {

    HashMap<String, Integer> memo = new HashMap<>();

    public int numDecodings(String s) {


        return dp(s);
    }

    int dp(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        if (s.length() <= 1) {
            return 1;
        }
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        int x = 0;
        int y = 0;
        if (s.length() > 0) {
            String singleS = s.substring(0, 1);
            if (isIn(singleS)) {
                x = dp(s.substring(1));
            }
            memo.put(s.substring(1), x);
        }
        if (s.length() >= 2) {
            String doubleS = s.substring(0, 2);
            if (isIn(doubleS)) {
                y = dp(s.substring(2));
            }
            memo.put(s.substring(2), y);

        }
        memo.put(s, x + y);
        return memo.get(s);
    }

    boolean isIn(String num) {
        int x = Integer.valueOf(num);
        return x <= 26 && x >= 1;
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
