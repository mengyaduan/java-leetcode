package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/">买卖股票 含手续费</a>
 **/
public class No714 {

    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length + 1][2];
        // 第一天以前，收益必为0，也不可能可以卖出
        for (int i = 0; i < prices.length + 1; i++) {
            dp[i][0] = 0;
            dp[i][1] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < prices.length + 1; i++) {
            // stay 或 卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            // stay 或 买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1] - fee);
        }
        return dp[prices.length][0];
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                {new int[]{1, 3, 2, 8, 4, 9}, 2, 8},
                {new int[]{1, 3, 7, 5, 10, 3}, 3, 6},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] m, int fee, int expected) {
        int res = maxProfit(m, fee);
        Assert.assertEquals(res, expected);
    }

}
