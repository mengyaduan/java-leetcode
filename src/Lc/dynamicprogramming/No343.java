package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/integer-break/?show=1">No343 整数拆分求最大积</a>
 **/
public class No343 {


    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int m = n % 3;
        if (m == 0) {
            int x = n / 3;
            return (int) (Math.pow(3, x));
        } else if (m == 1) {
            int x = n / 3 - 1;
            return (int) (4 * Math.pow(3, x));
        } else {
            int x = n / 3;
            return (int) (2 * Math.pow(3, x));
        }
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {2, 1},
                {3, 2},
                {4, 4},
                {5, 6},
                {10, 36},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int n, int expected) {
        int res = integerBreak(n);
        Assert.assertEquals(res, expected);
    }


}
