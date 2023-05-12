package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/fibonacci-number/">斐波那契数</a>
 **/
public class No509 {

    public int fib(int n) {
        int[] memo = new int[31];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {0, 0},
                {1, 1},
                {2, 1},
                {3, 2},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int n, int expected) {
        int res = fib(n);
        Assert.assertEquals(res, expected);
    }

}
