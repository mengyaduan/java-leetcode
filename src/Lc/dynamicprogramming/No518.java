package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/coin-change-ii/">凑零钱 ii</a>
 **/
public class No518 {

    int[][] memo;

    public int change(int amount, int[] coins) {
        int n = coins.length;
        memo = new int[n + 1][amount + 1];
        for (int j = 0; j <= amount; j++) {
            memo[0][j] = 0;
        }
        for (int i = 0; i <= n; i++) {
            memo[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] > j) {
                    memo[i][j] = memo[i - 1][j];
                } else {
                    memo[i][j] = memo[i - 1][j] + memo[i][j - coins[i - 1]];
                }
            }
        }
        return memo[n][amount];
    }

    @DataProvider(name = "cases")
    public Object[][] cases() {
        Object[][] data = {
                {new int[]{1, 2, 5}, 5, 4},
                {new int[]{2}, 3, 0},
                {new int[]{10}, 10, 1},
        };
        return data;
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] coins, int amount, int expected) {
        int res = change(amount, coins);
        Assert.assertEquals(res, expected);
    }
}
