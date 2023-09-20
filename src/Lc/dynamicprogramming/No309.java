package Lc.dynamicprogramming;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/">买卖股票 含冷静期</a>
 **/
public class No309 {

    public int maxProfit(int[] prices) {
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
            if (i < 3) {
                // 如果是前2天，可以stay或者随便买入
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
            } else {
                // 如果是第二天以后，再买入就得考虑冷静期了
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i - 1]);

            }
        }
        return dp[prices.length][0];
    }


    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                {new int[]{1, 2, 3, 0, 2}, 3},
                {new int[]{1}, 0},
        };
    }

    @Test(description = "单测", dataProvider = "cases")
    public void test(int[] m, int expected) {
        int res = maxProfit(m);
        Assert.assertEquals(res, expected);
    }

}
