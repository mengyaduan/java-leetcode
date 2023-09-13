package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/">买卖股票 iv</a>
 **/
public class No188 {

    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length + 1][k + 1][2];
        // 第一天以前，收益必为0，也不可能可以卖出
        for (int i = 0; i < prices.length + 1; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < k + 1; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < prices.length + 1; i++) {
            for (int dealNum = k; dealNum > 0; dealNum--) {
                // stay 或 卖出
                dp[i][dealNum][0] = Math.max(dp[i - 1][dealNum][0], dp[i - 1][dealNum][1] + prices[i - 1]);
                // stay 或 买入
                dp[i][dealNum][1] = Math.max(dp[i - 1][dealNum][1], dp[i - 1][dealNum - 1][0] - prices[i - 1]);
            }
        }
        return dp[prices.length][k][0];
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                {new int[]{2, 4, 1}, 2, 2},
                {new int[]{3, 2, 6, 5, 0, 3}, 2, 7},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] m, int k, int expected) {
        int res = maxProfit(k, m);
        Assert.assertEquals(res, expected);
    }

}
