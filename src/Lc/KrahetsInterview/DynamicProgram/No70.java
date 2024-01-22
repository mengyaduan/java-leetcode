package Lc.KrahetsInterview.DynamicProgram;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/climbing-stairs/description/">爬楼梯</a>
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
        return new Object[][]{
                //
                {6, 13},
                {7, 21},
                {8, 34},
                {9, 55},
                {10, 89},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int n, int expected) {
        Assert.assertEquals(climbStairs(n), expected);

    }

}

