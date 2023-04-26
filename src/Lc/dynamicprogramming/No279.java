package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/perfect-squares/?show=1">No279 完全平方数</a>
 **/
public class No279 {

    int[] memo;

    public int numSquares(int n) {
        memo = new int[100 * 100 + 1];
        Arrays.fill(memo, -1);
        for (int i = 1; i <= 100; i++) {
            memo[i * i] = 1;
        }
        return dp(n);
    }

    public int dp(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }
        ArrayList<Integer> choices = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (i * i < n) {
                choices.add(i * i);
            }
        }
        int cur = Integer.MAX_VALUE;
        for (Integer item : choices) {
            int res = dp(n - item) + 1;
            if (res < cur) {
                cur = res;
            }
        }
        memo[n] = cur;
        return cur;
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {12, 3},
                {13, 2},
                {1, 1},
                {2, 2},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int n, int expected) {
        int res = numSquares(n);
        Assert.assertEquals(res, expected);
    }
}
