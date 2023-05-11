package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/climbing-stairs/description/?show=1">爬楼梯</a>
 **/
public class No70 {

    int[] memo;
    public int climbStairs(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return dp(n);
    }

    public int dp(int n) {
        if (n <= 3) {
            return n;
        }
        if (memo[n] != -1) {
            return memo[n];
        }

        int res = dp(n - 1) + dp(n - 2);
        memo[n] = res;
        return res;
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {3, 3},
                {2, 2},
                {21, 17711},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int n, int expected) {
        int res = climbStairs(n);
        Assert.assertEquals(res, expected);
    }

}
