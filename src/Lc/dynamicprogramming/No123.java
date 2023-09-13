package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/">买卖股票 iii</a>
 **/
public class No123 {

    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length + 1][3][2];
        // 第一天以前，收益必为0，也不可能可以卖出
        dp[0][0][0] = 0;
        dp[0][1][0] = 0;
        dp[0][2][0] = 0;
        dp[0][0][1] = Integer.MIN_VALUE;
        dp[0][1][1] = Integer.MIN_VALUE;
        dp[0][2][1] = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length + 1; i++) {
            for (int k = 1; k < 3; k++) {
                // stay 或 卖出
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i - 1]);
                // stay 或 买入
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i - 1]);
            }
        }
        return dp[prices.length][2][0];
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                {new int[]{3, 3, 5, 0, 0, 3, 1, 4}, 6},
                {new int[]{1, 2, 3, 4, 5}, 4},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] m, int expected) {
        int res = maxProfit(m);
        Assert.assertEquals(res, expected);
    }

}
