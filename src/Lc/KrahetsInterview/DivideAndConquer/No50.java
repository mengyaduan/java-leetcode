package Lc.KrahetsInterview.DivideAndConquer;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/powx-n/description/">pow</a>
 **/
public class No50 {

    public double myPow(double x, int n) {
        long b = n;
        double res = 1;
        if (b < 0) {
            b = -b;
            x = 1 / x;
        }

        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b = b >> 1;
        }
        return res;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                //
                {2.0, 10, 1024.0},
                {2.0, -2, 0.25},
                {2.0, -2147483648, 0},
                {2.0, -2, 0.25},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(double x, int n, double expected) {
        double res = myPow(x, n);
        Assert.assertEquals(res, expected);

    }

    @Test(description = "")
    public void test123() throws Exception {
        System.out.println(Math.pow(2, -2147483648));

    }

}

