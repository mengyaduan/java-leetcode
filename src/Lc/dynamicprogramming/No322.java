package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/coin-change/?show=1/">No322 凑零钱</a>
 **/
public class No322 {

    int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -123);
        return dp(coins, amount);
    }

    public int dp(int[] coins, int amount) {
        int res = Integer.MAX_VALUE;
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != -123) {
            return memo[amount];
        }
        for (int coin : coins) {
            int subProblem = dp(coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, 1 + subProblem);
        }
        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[amount];
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{1, 2, 5}, 11, 3},
                {new int[]{2}, 3, -1},
                {new int[]{1}, 0, 0},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] coins, int amount, int expected) {
        int res = coinChange(coins, amount);
        Assert.assertEquals(res, expected);
    }
}
